package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFor
 */
@WebServlet("/ServletFor")
public class ServletFor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFor() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int numero=Integer.parseInt(request.getParameter("numero"));
		PrintWriter pw=response.getWriter();
		pw.println("<body>");
		pw.println("<html>");
		for (int i = 0;i<=numero;i++) {
			pw.println("<html><body>"+i+"</body></html>");
		}
			pw.println("</body>");
			pw.println("</html>");

	}

}
