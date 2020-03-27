package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

@WebServlet("/ServletDetalleLibro")
public class ServletDetalleLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String titulo = request.getParameter("titulo");
		Libro milibro = Libro.buscarPorTitulo(titulo);

		pw.println("<html><body>");

		pw.println(milibro.getIsbn());
		pw.println(milibro.getTitulo());
		pw.println(milibro.getAutor());
		pw.println(milibro.getPrecio());
		pw.println(milibro.getCategoria());

		pw.println("</html></body>");
	}

}
