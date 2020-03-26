package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class ServletListaLibros
 */
@WebServlet("/ServletListaLibrosJDBC")
public class ServletListaLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		
		ArrayList<Libro> milista= new ArrayList<Libro>();
		
		milista=Libro.buscarTodos();
	
		pw.println("<html><body>");
		
		for (Libro milibro:milista) {
			
			pw.println("<p>");
			pw.println(milibro.getIsbn());
			pw.println(milibro.getTitulo());
			pw.println(milibro.getAutor());
			pw.println(milibro.getPrecio());
			pw.println(milibro.getCategoria());
			pw.println("</p>");
			
		}
		pw.println("</body></html>");
		pw.close();
	}

}
