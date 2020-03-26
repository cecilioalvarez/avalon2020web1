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
		
		PrintWriter pw = response.getWriter();
		Libro libro1 = new Libro("20", "python", "juan", 20, "programacion");
		Libro libro2 = new Libro("1", "java", "jose", 20, "programacion");
		Libro libro3 = new Libro("2", "html", "jairo", 20, "programacion");
		Libro libro4 = new Libro("14", "css", "julian", 20, "programacion");
		Libro libro5 = new Libro("35", "javascript", "jaime", 20, "programacion");
		
		ArrayList<Libro> lista = new ArrayList<Libro>();
		lista.add(libro1);
		lista.add(libro2);
		lista.add(libro3);
		lista.add(libro4);
		lista.add(libro5);
		
				
		pw.println("<html><body>");
		
		for (Libro l: lista) {
			
			pw.println(l.getIsbn());
			pw.println(l.getTitulo());
			pw.println(l.getAutor());
			pw.println(l.getPrecio());
			pw.println(l.getCategoria());
			pw.println("<br>");
		}

		pw.println("</body></html>");
		pw.close();
	
	
	
	}

	

}
