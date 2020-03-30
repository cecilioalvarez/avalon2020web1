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
 * Servlet implementation class ServletOrdenar
 */
@WebServlet("/ServletOrdenar")
public class ServletOrdenar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Libro> listalibros= new ArrayList <Libro>();
		PrintWriter pw= response.getWriter();
		listalibros=Libro.ordenarTodos();
		pw.println("<html><body>");
		
		for(Libro n: listalibros) {
			
			
			pw.println("<p>");	
			
			pw.println ("<td>" +n.getIsbn()+"</td>");
			pw.println ("<td>"+n.getTitulo()+"</td>");
			pw.println ("<td>"+n.getAutor()+"</td>");
			pw.println ("<td>"+n.getPrecio()+"</td>");
			pw.println ("<td>"+n.getCategoria()+"</td>");
			pw.println ("<a href= 'ServletBorrarLibro?ISBN="+n.getIsbn()+"'>borrar</a>");
			pw.println("</p>");	
				
			}
		
		pw.println ("</body></html>");
		pw.close();
	}

}
