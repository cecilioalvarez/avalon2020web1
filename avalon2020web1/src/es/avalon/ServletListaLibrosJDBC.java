package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class ServletListaLibrosJDBC
 */
@WebServlet("/ServletListaLibrosJDBC")
public class ServletListaLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		List<Libro> lista = new ArrayList<Libro>();

		lista = Libro.buscarTodos();

		pw.println("<html><body>");

		for (Libro l : lista) {
			pw.println("<p>");
			pw.println(l.getIsbn());
			pw.println(l.getTitulo());
			pw.println(l.getAutor());
			pw.println(l.getPrecio());
			pw.println(l.getCategoria());
			//como generar un link en html y que lo dibuje el servlet
			//<a href='ServletBorrar?isbn=1'>borrar</a>
			pw.println("<a href='ServletBorrar?isbn="+l.getIsbn()+"'>borrar</a>");
			pw.println("</p>");

		}

		pw.println("</body></html>");
		pw.close();
	}

}
