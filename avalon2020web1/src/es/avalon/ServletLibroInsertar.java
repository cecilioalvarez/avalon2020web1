package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.jdbc.LibroRepository;
import es.avalon.repositorios.jdbc.LibroRepositoryJDBC;

/**
 * Servlet implementation class ServletLibroInsertar
 */
@WebServlet("/ServletLibroInsertar")
public class ServletLibroInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		int precio=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");

		Libro libro=new Libro(isbn, titulo, autor, precio, categoria);
		LibroRepository repositorio= new LibroRepositoryJDBC();
		repositorio.insertar(libro);
			
		PrintWriter pw=response.getWriter();
		pw.println("Libro insertado en la base de datos");
	}


}
