package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter pw= response.getWriter();
    	//String isbn=request.getParameter("ISBN");
    	String titulo= request.getParameter("titulo");//Titulo para la otra forma
    	Libro libro= Libro.buscarPorTitulo(titulo);
    
    	pw.println("<html><body>");
    	//pw.println("<p>");
    	pw.println(libro.getIsbn());
    	pw.println(libro.getTitulo());
    	pw.println(libro.getAutor());
    	pw.println(libro.getPrecio());
    	pw.println(libro.getCategoria());
    //pw.println("</p>");
    	pw.println("</body></html>");
    	
	}

}
