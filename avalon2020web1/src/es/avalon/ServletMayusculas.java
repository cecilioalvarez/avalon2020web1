package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletMayusculas")
public class ServletMayusculas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<p>El nombre en mayusculas es:");
		pw.println(nombre.toUpperCase());
		pw.println("</p>");
		pw.println("</body></html>");

	}

}
