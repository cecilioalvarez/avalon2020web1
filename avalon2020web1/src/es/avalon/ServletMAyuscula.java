package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMAyuscula
 */
@WebServlet("/ServletMAyuscula")
public class ServletMAyuscula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellidos");
		PrintWriter pw= response.getWriter();
		
		pw.println("" +nombre.toUpperCase()+" "+ apellido.toUpperCase()+"");
		
	}

}
