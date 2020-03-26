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
 * Servlet implementation class ServletLibroTabla
 */
@WebServlet("/ServletLibroTabla")
public class ServletLibroTabla extends HttpServlet {
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
		pw.println("<table border='5px solid black;'>");
		pw.println("<tr>\r\n" + 
    			"	<th>ibsn</th>\r\n" + 
    			"	<th>titulo</th>\r\n" + 
    			"	<th>autor</th>\r\n" + 
    			"	<th>precio</th>\r\n" + 
    			"	<th>categoria</th>\r\n" + 
    			"</tr>");
    	pw.println("<tr>");
        for(Libro l:lista){ 
        	
        	pw.println("<td>"+l.getIsbn()+"</td>");
    		pw.println("<td>"+l.getTitulo()+"</td>");
    		pw.println("<td>"+l.getAutor()+"</td>");
    		pw.println("<td>"+l.getPrecio()+"</td>");
    		pw.println("<td>"+l.getCategoria()+"</td>");
    		pw.println("</tr>");
        }
        pw.println("</table>");
        pw.println("</body></html>");
		pw.close();
	}

}
