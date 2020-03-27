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
 * Servlet implementation class ServletCombo
 */
@WebServlet("/ServletCombo")
public class ServletCombo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCombo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw= response.getWriter();
		
		ArrayList<Libro> listaLibros= Libro.buscarTodos();
		
		pw.println("<html><body>");
		pw.println("<form action='ServletDetalle'>");
		pw.println("<select name='titulo'>");
		
		for (Libro l:listaLibros) {
			
			pw.println("<option>"+l.getTitulo() +"</option>");
			
		}
		
		pw.println("</select>");
		pw.println("<input type='submit' value='enviar'/>");
		
		pw.println("</form>");
		pw.println("</body></html>");
	
		
		
		
	}

	

}
