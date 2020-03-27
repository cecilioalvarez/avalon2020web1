package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class ServletInsertarLibro
 */
@WebServlet("/ServletInsertarLibro")
public class ServletInsertarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw= response.getWriter();
		String isbn=request.getParameter("ISBN");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		int precio=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
	
		Libro libro= new Libro (isbn, titulo, autor, precio, categoria);
		
		libro.insertar();
		
		
		
		pw.println("<p> los datos insertados en la base de datos son son:");
		pw.println(" ISBN: " +isbn+"");
		pw.println(" Titulo: "+titulo+"");
		pw.println(" Autor: "+autor+"");
		pw.println("Precio: "+precio +"€");
		pw.println("Categoria : "+categoria+"");
		pw.println("</p>");
		pw.close();
		
		
		
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
