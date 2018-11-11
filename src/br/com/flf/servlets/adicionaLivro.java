package br.com.flf.servlets;

import br.com.flf.jdbc.LivroDAO;
import br.com.flf.models.Livro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/adicionaLivro")
public class adicionaLivro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public adicionaLivro() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            Livro livro = new Livro();
            livro.setAno(Integer.valueOf(request.getParameter("ano")));
            livro.setGenero(request.getParameter("genero"));
            livro.setAutores(request.getParameter("autores"));
            livro.setEditora(request.getParameter("editora"));
            livro.setTitulo(request.getParameter("titulo"));
            LivroDAO dao = new LivroDAO();

            dao.adiciona(livro);
            out.println("<html>");
            out.println("<body>");
            out.println("Livro: \"" + livro.getTitulo() + "\",adicionado!");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.print(e);
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}