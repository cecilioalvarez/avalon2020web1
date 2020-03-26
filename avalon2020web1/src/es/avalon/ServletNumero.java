package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletNumero
 */
@WebServlet("/ServletNumero")
public class ServletNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("numero")!=null) {
			
			
			int numero= Integer.parseInt(request.getParameter("numero"));
			
			
			
			PrintWriter pw= response.getWriter();
			pw.println("<html>");
			pw.println("<body>");
			for (int i=0;i<10;i++) {
				
				pw.println("<p>"+numero+"x"+i+"="+(numero*i)+"</p>");
			}
			pw.println("</body>");
			pw.println("</html>");
			
		}
		else {
			
			PrintWriter pw= response.getWriter();
			pw.println("no hay numero");
		}
	}


	

}
