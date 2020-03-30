package es.avalon.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

import javax.servlet.*;
/**
 * Servlet implementation class ServletLibros
 */
@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Libro> listalibros= new ArrayList<Libro>();
		listalibros= Libro.buscarTodos();
		//crear el desahachor y decir a donde vamos
		RequestDispatcher despachador=request.getRequestDispatcher("libros2/Listalibros.jsp");
		//asignar datos adicionales
		request.setAttribute("Listalibros", listalibros);
		//reenvio
		despachador.forward(request,response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
