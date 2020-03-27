package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

@WebServlet("/ServletDetalle")
public class ServletDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		String titulo = request.getParameter("titulo");

		Libro libro = Libro.buscarPorTitulo(titulo);

		pw.println("<html><body>");

		pw.println("<p>"+libro.getIsbn()+"</p>");
		pw.println("<p>"+libro.getTitulo()+"</p>");
		pw.println("<p>"+libro.getAutor()+"</p>");
		pw.println("<p>"+libro.getPrecio()+"</p>");
		pw.println("<p>"+libro.getCategoria()+"</p>");

		pw.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
