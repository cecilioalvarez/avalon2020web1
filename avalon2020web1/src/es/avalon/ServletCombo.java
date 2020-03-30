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

PrintWriter pw=response.getWriter();
		
		ArrayList<Libro> milista= new ArrayList<Libro>();
		
		milista=Libro.buscarTodos();
	
		pw.println("<html><body>");
		pw.println("<form action='ServletDetalle'>");
		pw.println("<p>");
		pw.println("<select name='titulo'>");
		
		for (Libro milibro:milista) {
			
			pw.println("<option>");
			pw.println(milibro.getTitulo());
			pw.println("</option>");
		}
		
		pw.println("</select>");
		pw.println("</p>");
		pw.println("<input type='submit' value='enviar'/>");
		pw.print("</form>");
		pw.println("</body></html>");
		pw.close();
	}


}
