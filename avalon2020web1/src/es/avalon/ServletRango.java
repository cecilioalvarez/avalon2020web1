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
		
		int numInicial = Integer.parseInt(request.getParameter("n1"));
		int numFinal= Integer.parseInt(request.getParameter("n2"));
		
		PrintWriter pw = response.getWriter();
		
		for (int i = numInicial; i <= numFinal; i++) {
			pw.println("<html><body>"+i+"<br></body></html>");
			}
		
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
