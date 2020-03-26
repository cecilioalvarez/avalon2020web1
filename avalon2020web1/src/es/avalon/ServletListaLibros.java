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
		// TODO Auto-generated method stub

		
		PrintWriter pw= response.getWriter();
		Libro milibro= new Libro("20","python","juan",20,"programacion");
		Libro milibro2= new Libro("20","python","juan",20,"programacion");
		Libro milibro3= new Libro("20","python","juan",20,"programacion");
		Libro milibro4= new Libro("20","python","juan",20,"programacion");
		Libro milibro5= new Libro("20","python","juan",20,"programacion");
		
		ArrayList<Libro> lista= new ArrayList<Libro>();
		lista.add(milibro);
		lista.add(milibro2);
		lista.add(milibro3);
		lista.add(milibro4);
		lista.add(milibro5);
		
		pw.println("<html><body>");
		
		
		
		for (Libro l: lista) {
			pw.println("<p>");
			pw.println(l.getIsbn());
			pw.println(l.getTitulo());
			pw.println(l.getAutor());
			pw.println(l.getPrecio());
			pw.println(l.getCategoria());
			pw.println("</p>");
			
		}
		
		pw.println("</body></html>");
		pw.close();
	}

	

}
