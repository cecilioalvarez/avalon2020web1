package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Numero2
 */
@WebServlet("/Numero2")
public class Numero2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Numero2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		
		for (int i = 0; i <= 10 ; i++) {
			pw.println("<p>"+numero+"*"+i+"="+numero*i+"</p>");
			}
		
		pw.println("</body></html>");
	}

	

}
