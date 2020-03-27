package es.avalon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

@WebServlet("/ServletBorrarLink")
public class ServletBorrarLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		Libro l = new Libro(isbn);
		l.borrar();
		//Esta es una redireccion que nos permite volver al listado y mostrar uno menos
		response.sendRedirect("ServletListaLibrosjdbc");
	}


}
