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

		int Num1=Integer.parseInt(request.getParameter("Num1"));
		int Num2=Integer.parseInt(request.getParameter("Num2"));
		
		PrintWriter pw=response.getWriter();
		
		for(int i=Num1; i<=Num2 ;i++) {
			
			pw.println(i);
			
		}
		

	

	}

}
