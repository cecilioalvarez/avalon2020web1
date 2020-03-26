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


@WebServlet("/ServletListaLibros")
public class ServletListaLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter(); 
		
		Libro libro1=new Libro("20","python","Juan",20,"programacion");
		Libro libro2=new Libro("20","python","Juan",20,"programacion");
		Libro libro3=new Libro("20","python","Juan",20,"programacion");
		Libro libro4=new Libro("20","python","Juan",20,"programacion");
		Libro libro5=new Libro("20","python","Juan",20,"programacion");
		
		ArrayList<Libro> listalibros=new ArrayList<Libro>();
		
		listalibros.add(libro1);
		listalibros.add(libro2);
		listalibros.add(libro3);
		listalibros.add(libro4);
		listalibros.add(libro5);
		
		
		pw.println("<html><body>");
		for(Libro l:listalibros) {
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
