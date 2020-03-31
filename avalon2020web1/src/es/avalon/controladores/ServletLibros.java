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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher despachador = null;
		String accion = request.getParameter("accion");

		if (accion != null) {

			if (accion.equals("formularioInsertar")) {
				despachador = request.getRequestDispatcher("libros2/formularioInsertar.jsp");
			}
			//Accion=borrar
			else if (accion.equals("borrar")) {
				// Recepcionar
				String isbn = request.getParameter("isbn");
				//Borrar
				Libro l = new Libro(isbn);
				l.borrar();
				// Cargar nuevo listado
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			}
			//Ver detalle
			else if (accion.contentEquals("detalle")) {
				despachador = request.getRequestDispatcher("libros2/verDetalle.jsp");
				
			}
			//Editar
			else if (accion.contentEquals("editar")) {
				despachador = request.getRequestDispatcher("libros2/editar.jsp");
				
			}
			else if (accion.equals("salvar")) {
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");
				//Salvar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				milibro.salvar();
				// Cargar nuevo listado
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			}
			
			// Accion=insertar este else es lo mismo que -->//else if (accion.equals("formularioInsertar")) {
			else{
				// Recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");
				// Insertar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				milibro.insertar();
				// Cargar nuevo listado
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			}
			
		}

		// no hay acion
		else {

			List<Libro> listaLibros = new ArrayList<Libro>();

			listaLibros = Libro.buscarTodos();

			despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			request.setAttribute("listaLibros", listaLibros);
		}
		// Sean de un interface
		despachador.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
