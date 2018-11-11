package br.com.flf.servlets;

import br.com.flf.jdbc.FilmeDAO;
import br.com.flf.jdbc.LivroDAO;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/listaLivros")
public class listaLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listaLivros() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LivroDAO dao = new LivroDAO();
		List<Livro> rows;
		
		try {
			rows = dao.getLivros();
		
		out.println("<html>");
        out.println("<body>");
        
        try {
			out.println("Quantidade de Livros cadastrados: " + rows.size());
			if (rows.size()>0)
			for (int i = 0; i < rows.size(); i++) {
				out.println("<li> id:"+rows.get(i).getId()+" - "+rows.get(i).getTitulo()+"</li>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        out.println("</body>");
        out.println("</html>");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
