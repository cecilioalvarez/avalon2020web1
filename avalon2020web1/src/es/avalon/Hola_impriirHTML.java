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
@WebServlet("/Hola_imprimiirHTML")
public class Hola_impriirHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		PrintWriter pw=response.getWriter();
//		pw.println("<html><body>hola desde un servlet </body></html>");
	int nota=Integer.parseInt(request.getParameter("nota"));
	PrintWriter pw=response.getWriter();
	
	if(nota>=5) {
		pw.println("<html><body>has aprobado</body></html>");
	}else {
		pw.println("<html><body>has suspendido</body></html>");
	}
	
	
	
	}

}
