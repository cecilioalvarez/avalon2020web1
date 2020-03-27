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
 * Servlet implementation class ServletDetalle
 */
@WebServlet("/ServletDetalle")
public class ServletDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		
		String titulo=request.getParameter("titulo");
		
		Libro milibro=Libro.buscarPorTitulo(titulo);
		
		pw.println("<html><body>");
		
		pw.println("<p>"+milibro.getTitulo()+"</p>");
		pw.println("<p>"+milibro.getIsbn()+"</p>");
		pw.println("<p>"+milibro.getAutor()+"</p>");
		pw.println("<p>"+milibro.getPrecio()+"</p>");
		pw.println("<p>"+milibro.getCategoria()+"</p>");
		
		pw.println("</html></body>");
		
	}


}
