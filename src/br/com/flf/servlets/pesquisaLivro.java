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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/pesquisaLivro")
public class pesquisaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pesquisaLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("key");
		LivroDAO dao = new LivroDAO();
		List<Livro> result = new ArrayList<Livro>();
		
		result = dao.getPesquisa(pesquisa);
		request.setAttribute("lista_req", result);
		RequestDispatcher disp = request.getRequestDispatcher("pesquisa-livro.jsp");
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
