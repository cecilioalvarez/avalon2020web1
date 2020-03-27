package es.avalon;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;


@WebServlet("/Servet2addLibrosJDBC")
public class Servet2addLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String ISBN=request.getParameter("ISBN");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		int precio=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
		
		Libro addlibro=new Libro(ISBN,titulo,autor,precio,categoria);
		
		addlibro.insertar();
	}

}
