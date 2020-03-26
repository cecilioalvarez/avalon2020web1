package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRango
 */
@WebServlet("/ServletRango")
public class ServletRango extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ninicial=Integer.parseInt(request.getParameter("n1"));
		int nfinal=Integer.parseInt(request.getParameter("n2"));
		PrintWriter pw= response.getWriter();
		
		for (int i=ninicial; i<=nfinal; i++) {
			pw.println("<p><html><body>" +i +"</body></html> </p>");
		}
		

	}

}
