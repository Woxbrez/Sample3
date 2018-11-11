package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.flf.models.Livro;

public class LivroDAO {
	public void adiciona(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       

		String sql = "insert into livro " +
				"(titulo,autores,genero,editora,ano)" +
				" values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, novo.getTitulo());
			stmt.setString(2, novo.getAutores());
			stmt.setString(3, novo.getGenero());
			stmt.setString(4, novo.getEditora());
			stmt.setInt(5, novo.getAno());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}
	
	public void altera(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       

		String sql = "update Livro set titulo=?, autores=?, genero=?, editora=?,"+
				"ano=? where id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, novo.getTitulo());
			stmt.setString(2, novo.getAutores());
			stmt.setString(3, novo.getGenero());
			stmt.setString(4, novo.getEditora());
			stmt.setInt(5, novo.getAno());
			stmt.setLong(6, novo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}
	
	public void delete(long id) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		String sql = "delete from livro where id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setLong(1,id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		conx.close(conn);

	}
	
	public Livro getLivro(long id) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		Livro livro = new Livro();
		PreparedStatement stmt = conn.prepareStatement("select * from Livro where id="+id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			livro = new Livro();
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutores(rs.getString("autores"));
			livro.setGenero(rs.getString("genero"));
			livro.setEditora(rs.getString("editora"));
			livro.setAno(rs.getInt("ano"));
			livro.setId(rs.getLong("id"));
			stmt.close();
			conn.close();
			
			return livro;
		}
		
		stmt.close();
		conn.close();
		return null;
	}

	public List<Livro> getLivros() throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		List<Livro> listLivros = new ArrayList<>();
		Livro livro = null;
		PreparedStatement stmt = conn.prepareStatement("select * from Livro");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			livro = new Livro();
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutores(rs.getString("autores"));
			livro.setGenero(rs.getString("genero"));
			livro.setEditora(rs.getString("editora"));
			livro.setAno(rs.getInt("ano"));
			livro.setId(rs.getLong("id"));
			listLivros.add(livro);
		}
		
		stmt.close();
		conn.close();
		return listLivros;
	}

	public List<Livro> getPesquisa(String key){
		List<Livro> listLivros = new ArrayList<>();
		Livro livro;
		Conexao conx = new Conexao();
		Connection conn;
		try {
			conn = conx.abrir();
		       
		PreparedStatement stmt = conn.prepareStatement("select * from Livro where genero like ?");
		stmt.setString(1,"%"+key+"%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			livro = new Livro();
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutores(rs.getString("autores"));
			livro.setGenero(rs.getString("genero"));
			livro.setEditora(rs.getString("editora"));
			livro.setAno(rs.getInt("ano"));
			livro.setId(rs.getLong("id"));
			listLivros.add(livro);
		}
		
		stmt.close();
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLivros;
	}
}
