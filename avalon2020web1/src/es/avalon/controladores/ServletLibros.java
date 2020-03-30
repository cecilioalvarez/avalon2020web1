package es.avalon.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;

/**
 * Servlet implementation class Libro
 */
@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Libro> listaLibros=new ArrayList<Libro>();
		
		listaLibros=Libro.buscarTodos();
		
		//Crear el despachador y decir a donde vamos
		RequestDispatcher despachador=request.getRequestDispatcher("libros2/ListaLibros.jsp");	
		//Asignar los datos adicionales
		request.setAttribute("listaLibros", listaLibros);
		//Reenvio
		despachador.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
