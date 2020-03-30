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
 * Servlet implementation class ServletOrdenAlfabetico
 */
@WebServlet("/ServletOrdenAlfabetico")
public class ServletOrdenAlfabetico extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		
		ArrayList<Libro> ordenlista= new ArrayList<Libro>();
		
		ordenlista=Libro.ordenAlfabetico();
	
		pw.println("<html><body>");
		
		for (Libro milibro:ordenlista) {
			
			pw.println("<p>");
			pw.println(milibro.getTitulo());
			pw.println(milibro.getIsbn());
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
