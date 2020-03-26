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


@WebServlet("/ServletListaLibrosJDBC")
public class ServletListaLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
	
		ArrayList<Libro> lista = new ArrayList<Libro>();
		lista = Libro.buscarTodos();
				
		pw.println("<html><body><table border=\"1px solid color=red\">");
		pw.println("<tr>");
		pw.println("<th>ISBN</th>");
		pw.println("<th>Titulo</th>");
		pw.println("<th>Autor</th>");
		pw.println("<th>Precio</th>");
		pw.println("<th>Categoria</th>");
		pw.println("</tr>");
		
		for (Libro l: lista) {
			
			pw.println("<tr>");
			pw.println("<td>"+l.getIsbn()+"</td>");
			pw.println("<td>"+l.getTitulo()+"</td>");
			pw.println("<td>"+l.getAutor()+"</td>");
			pw.println("<td>"+l.getPrecio()+"</td>");
			pw.println("<td>"+l.getCategoria()+"</td>");
			pw.println("</tr>");

			
		}

		pw.println("</table></body></html>");
		pw.close();
	
	
	
	}
	
}

	

