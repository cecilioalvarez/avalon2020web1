package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletRango")
public class ServletRango extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int numero1=Integer.parseInt(request.getParameter("numero1"));
		int numero2=Integer.parseInt(request.getParameter("numero2"));
		
		PrintWriter pw=response.getWriter();
		pw.println("<body>");
		pw.println("<html>");
		for (int i = numero1;i<=numero2;i++) {
			pw.println("<html><body>"+i+"</body></html>");
		}
			pw.println("</body>");
			pw.println("</html>");
	}

}
