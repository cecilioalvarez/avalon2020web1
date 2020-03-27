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
 * Servlet implementation class ServletBorrarLibro
 */
@WebServlet("/ServletBorrarLibro")
public class ServletBorrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn= request.getParameter("isbn");
		
		Libro milibro= new Libro(isbn);
		milibro.borrar();
		response.sendRedirect("ServletListaLibrosJDBC");
	}

}
