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
 * Servlet implementation class ServletEliminarLibro
 */
@WebServlet("/ServletEliminarLibro")
public class ServletEliminarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		
		Libro milibro = new Libro(isbn);
		
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("El siguiente libro ha sido eliminado de la base de datos:<br>");
		
		pw.println(milibro.getIsbn());

		pw.println("</body></html>");
		pw.close();
		
		milibro.eliminar();

	}

	

}
