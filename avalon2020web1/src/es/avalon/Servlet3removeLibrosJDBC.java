package es.avalon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

@WebServlet("/Servlet3removeLibrosJDBC")
public class Servlet3removeLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ISBN=request.getParameter("ISBN");
		
		Libro removelibro=new Libro(ISBN);
		
		removelibro.borrar();
		
		response.sendRedirect("Servlet1ListaLibrosJDBC");
	}

}
