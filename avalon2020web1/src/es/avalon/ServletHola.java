package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//  (GET) http://localhost/avalonWeb001/ServletHola

@WebServlet("/ServletHola")
public class ServletHola extends HttpServlet {
	private static final long serialVersionUID = 1L;

    //este metodo
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>hola desde un servlet</body></html>");
	
	}
	

}
