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

@WebServlet("/ServletListaLibrosjdbc")
public class ServletListaLibrosjdbc extends HttpServlet {
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
			pw.println("<a href='ServletBorrarLink?isbn="+l.getIsbn()+"'>borrar</a>");
			pw.println("</p>");

		}

		pw.println("</body></html>");
		pw.close();

	}

}
