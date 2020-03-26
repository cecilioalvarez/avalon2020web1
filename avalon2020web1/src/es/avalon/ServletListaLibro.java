package es.avalon;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class ServletLibro
 */
@WebServlet("/ServletListaLibro")
public class ServletListaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw= response.getWriter();
		Libro milibro1= new Libro("20", "python", "juan", 20, "programacion");
		Libro milibro2= new Libro("30", "recetas con chocolate", "andres", 22, "cocina");
		Libro milibro3= new Libro("40", "walk", "jesus", 25, "danza");
		Libro milibro4= new Libro("50", "tennis avanzado", "pepe", 15, "deporte");
		Libro milibro5= new Libro("60", "bancos online", "roberto", 30, "economia");

		ArrayList<Libro> listalibros= new ArrayList <Libro>();
		listalibros.add(milibro1);
		listalibros.add(milibro2);
		listalibros.add(milibro3);
		listalibros.add(milibro4);
		listalibros.add(milibro5);
		
		pw.println("<html><body>");
		//pw.println("<table><tr>");
		pw.println("<table border=2px solid red><tr>");
		
		pw.println("	<tr>");
		pw.println("<th>ISBN</th>");
	pw.println("<th>Titulo</th>");
	pw.println("<th>Autor</th>");
	pw.println("<th>Precio</th>");
	pw.println("<th>Categoria</th>");
	pw.println("</tr>");
		
		for(Libro n: listalibros) {
		
		pw.print ("<html><body>");
		pw.println("<tr>");	
		
		pw.println ("<td>" +n.getIsbn()+"</td>");
		pw.println ("<td>"+n.getTitulo()+"</td>");
		pw.println ("<td>"+n.getAutor()+"</td>");
		pw.println ("<td>"+n.getPrecio()+"</td>");
		pw.println ("<td>"+n.getCategoria()+"</td>");
		
		pw.println("</tr>");	
			
		}
		pw.println("</tr></table>");
		pw.println ("</body></html>");
		
		pw.close();
	}

}
