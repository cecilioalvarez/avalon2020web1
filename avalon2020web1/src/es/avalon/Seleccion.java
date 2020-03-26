package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Seleccion
 */
@WebServlet("/ServletSeleccion")
public class Seleccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String numeroSeleccionado = request.getParameter("eleccion");
	PrintWriter pw = response.getWriter();
	pw.println(numeroSeleccionado);
	
}
}