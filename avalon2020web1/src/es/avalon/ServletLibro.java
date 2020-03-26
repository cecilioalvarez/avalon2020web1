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
 * Servlet implementation class ServletLibro
 */
@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Libro milibro= new Libro("20", "python", "juan", 20, "programacion");
		PrintWriter pw= response.getWriter();
		
		pw.println("<html></body>");
		pw.println(milibro.getIsbn());
		pw.println(milibro.getTitulo());
		pw.println(milibro.getAutor());
		pw.println(milibro.getPrecio());
		pw.println(milibro.getCategoria());
		pw.println("</body></html>");
		pw.close();
	}

	

}
