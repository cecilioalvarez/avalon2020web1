package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hola
 */
@WebServlet("/Hola3_TMultiplicar")
public class Hola3_TMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		
	int numero=Integer.parseInt(request.getParameter("numero"));
	PrintWriter pw=response.getWriter();
	
	for (int i=0; i<=numero; i++) {
		
		pw.println("<p><html><body>" +i*numero +"</body></html></p>");

	}
	
	
	}

}
