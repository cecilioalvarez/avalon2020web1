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
		
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body><table border=\"1px solid color=red\">");
		
		
		for (int i = 0; i <= 10 ; i++) {
			
			pw.println("<tr><td>"+numero+"*"+i+"="+numero*i+"</td></tr>");

			}
		
		pw.println("</table></body></html>");
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
