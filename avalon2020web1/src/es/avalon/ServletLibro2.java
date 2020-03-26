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
 * Servlet implementation class ServletLibro2
 */
@WebServlet("/ServletLibro2")
public class ServletLibro2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
		Libro milibro1= new Libro("20", "python", "juan", 20, "programacion");
		Libro milibro2= new Libro("15", "c++", "gema", 25, "programacion");
		Libro milibro3= new Libro("67", "html", "antonio", 19, "web");
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		lista.add(milibro1);
		lista.add(milibro2);
		lista.add(milibro3);
		
		pw.println("<html></body>");
        for(Libro l:lista){ 
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
