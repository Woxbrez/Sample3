package br.com.flf.servlets;

import br.com.flf.jdbc.LivroDAO;
import br.com.flf.models.Livro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/alteraLivro")
public class alteraLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public alteraLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			Livro livro = new Livro();
			livro.setEditora(request.getParameter("editora"));
			livro.setTitulo(request.getParameter("titulo"));
			livro.setGenero(request.getParameter("genero"));
			livro.setAutores(request.getParameter("autores"));
			livro.setAno(Integer.valueOf(request.getParameter("ano")));
			LivroDAO dao = new LivroDAO();

			dao.altera(livro);

		} catch (Exception e) {
			e.printStackTrace();
		}
        RequestDispatcher disp = request.getRequestDispatcher("listar-livro.jsp");
		disp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
