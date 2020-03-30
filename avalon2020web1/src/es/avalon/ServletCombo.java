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
 * Servlet implementation class ServletCombo
 */
@WebServlet("/ServletCombo")
public class ServletCombo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Libro> listalibros= new ArrayList <Libro>();
		PrintWriter pw= response.getWriter();
		listalibros=Libro.buscarTodos();
		pw.println("<html><body>");
//		for(Libro n: listalibros) {
//			
//			pw.println("<p>");	
//				
//			pw.println ("<td>"+n.getTitulo()+"</td>");
//			
//			pw.println ("<a href= 'ServletDetalle?Titulo="+n.getTitulo()+"'> mas info </a>");
//			//pw.println ("<a href= 'ServletDetalle?ISBN="+n.getIsbn()+"'> </a>");
//			pw.println("</p>");	
//				
//			}
//		
//		pw.println ("</body></html>");
//		pw.close();
		
		
		//****************************
		
	
		pw.println("<form action='ServletDetalle'>");	
		pw.println("<select name='titulo'>");
		for (Libro l: listalibros) {
			pw.println("<option>"+l.getTitulo()+"</option>");	
			
		}
		pw.println("</select>");	
		pw.println("<input type='submit' value='enviar'> </input>");	
		pw.println("</form>");	
		pw.println ("</body></html>");
		
		
		
		
		
		
	}
	
	}

