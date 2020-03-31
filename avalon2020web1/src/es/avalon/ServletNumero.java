package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExamen
 */
@WebServlet("/ServletNumero")
public class ServletNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero= Integer.parseInt(request.getParameter("numero"));
		
		PrintWriter pw= response.getWriter();
		
		pw.println("<html>");
		pw.println("<body>");
		for (int i = 0; i <= numero; ++i) {
			
			pw.println("<p>"+i+"<p>");
			
		}
		pw.println("</body>");
		pw.println("</html>");
		
	}

	
}