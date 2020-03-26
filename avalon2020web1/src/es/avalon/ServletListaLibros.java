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
@WebServlet("/ServletListaLibros")
public class ServletListaLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		Libro milibro1=new Libro("20","Python", "Juan", 20,"Programacion");
		Libro milibro2=new Libro("21","Java", "Pepe", 25,"Programacion");
		Libro milibro3=new Libro("22","Web", "Ines", 28,"Programacion");
		Libro milibro4=new Libro("23","Java2", "Pablo", 16,"Programacion");
		
		ArrayList<Libro> milista= new ArrayList<Libro>();
		
		milista.add(milibro1);
		milista.add(milibro2);
		milista.add(milibro3);
		milista.add(milibro4);
		
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
