package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTablaMult")
public class ServletTablaMult extends HttpServlet {
	private static final long serialVersionUID = 1L;   

    public ServletTablaMult() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero=Integer.parseInt(request.getParameter("numero"));
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		
		for (int i=0; i<=10; i++) {
		
			int mult=numero*i;
			pw.println("<p>"+numero+"x"+i+"=" + mult +"</p>");
			
		}
		
		pw.println("</html>");
		pw.println("</body>");
		
	}

}
