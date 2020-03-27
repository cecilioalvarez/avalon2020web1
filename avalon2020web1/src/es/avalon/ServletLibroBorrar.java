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
 * Servlet implementation class ServletLibroBorrar
 */
@WebServlet("/ServletLibroBorrar")
public class ServletLibroBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn=request.getParameter("isbn");
		
		Libro libro=new Libro(isbn);
		libro.borrar();
		// esta es una redireccion que nos permite volver al listado y mostrar uno menos
		response.sendRedirect("ServletListaLibrosJDBC");
		
		PrintWriter pw=response.getWriter();
		pw.println("Libro borrado");
		
	}


}
