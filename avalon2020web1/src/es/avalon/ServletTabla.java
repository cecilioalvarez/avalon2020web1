package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTabla
 */
@WebServlet("/ServletTabla")
public class ServletTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println("<table><tr>");
		//pw.println("<table border=2px solid red><tr>");
		for (int i =1; i<=10; i++  ) {
			
			//pw.println("<td> "+i+"</td> "); //una fila muchas columnas
			
			
			pw.println("<tr> <td>"+i+" </td></tr> "); // una columna, muchas filas
				
		}
		pw.println("</tr> </table>");
		pw.println("</html></body>");


	
	
	}

}
