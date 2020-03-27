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

@WebServlet("/ServletCombo")
public class ServletCombo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletCombo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		ArrayList<Libro> lista = Libro.buscarTodos();

		pw.println("<html><body>");
		pw.println("<form action='ServletDetalle'>");
		pw.println("<select name='titulo'>");

		for (Libro l : lista) {

			pw.println("<option>" + l.getTitulo() + "</option>");

		}

		pw.println("</select>");
		pw.println("<input type='submit' value='enviar'/>");
		pw.println("</form>");
		pw.println("</body></html>");
		pw.close();

	}
}
