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
@WebServlet("/ServletExamen")
public class ServletExamen extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletExamen() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nota= Integer.parseInt(request.getParameter("nota"));
		PrintWriter pw= response.getWriter();
		
		if (nota >=5) {
			pw.println("<html><body>has aprobado</body></html>");
		}else {
			pw.println("<html><body>has suspendido</body></html>");
		}
	}

	
}
