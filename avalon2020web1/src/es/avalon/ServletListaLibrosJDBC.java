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
import es.avalon.repositorios.jdbc.LibroRepositoryJDBC;

/**
 * Servlet implementation class ServletListaLibros
 */
@WebServlet("/ServletListaLibrosJDBC")
public class ServletListaLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		
		List<Libro> milista= new ArrayList<Libro>();
		
		milista=LibroRepositoryJDBC.buscarTodos();
	
		pw.println("<html><body>");
		
		for (Libro milibro:milista) {
			
			pw.println("<p>");
			pw.println(milibro.getIsbn());
			pw.println(milibro.getTitulo());
			pw.println(milibro.getAutor());
			pw.println(milibro.getPrecio());
			pw.println(milibro.getCategoria());
			// como generar un link en html y que los dibuje en el servlet
			// <a hred=!ServletLibroBorrar?isbn=1>borrar</a>
			pw.println("<a href='ServletLibroBorrar?isbn="+milibro.getIsbn()+"'>borrar</a>");
			pw.println("</p>");
			
		}
		pw.println("</body></html>");
		pw.close();
	}

}
