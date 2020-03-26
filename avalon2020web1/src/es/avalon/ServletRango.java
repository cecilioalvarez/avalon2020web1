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

		int numInic = Integer.parseInt(request.getParameter("numInic"));
		int numFin = Integer.parseInt(request.getParameter("numFin"));
		
		PrintWriter pw=response.getWriter();
		pw.println("<p> El rango de numeros es:");
		
		for (int i=numInic; i<=numFin; i++) {
			
			pw.println(i);
		}
		
		pw.println("</p>");
		pw.println();
	}

}
