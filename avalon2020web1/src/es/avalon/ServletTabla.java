package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTabla")
public class ServletTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<body>");
		pw.println("<html>");
		
		pw.println("<table border='1px solid orange'>");
		
		for (int i = 0;i<=10;i++) {
			pw.println("<tr>");	
			pw.println("<td>");	
			pw.println("<html><body>"+i+"</body></html>");
			pw.println("</td>");	
			pw.println("</tr>");	
		}
	
		pw.println("<table/>");
			pw.println("</body>");
			pw.println("</html>");
		
	}

}
