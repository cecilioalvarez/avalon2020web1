package es.avalon.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class Libros
 */
@WebServlet("/Libros")
public class Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Libro> listaLibros=new ArrayList<Libro>();
		listaLibros=Libro.buscarTodos();
		// crear el despachador y decir donde vamos
		RequestDispatcher despachador=request.getRequestDispatcher("libros2/listaLibros.jsp");
		// asignar los datos adicionales
		request.setAttribute("listaLibros",listaLibros);
		// reenvio
		despachador.forward(request,  response);
		
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
