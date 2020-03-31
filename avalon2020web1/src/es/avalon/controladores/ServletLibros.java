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
			} else if(accion.equals("borrar")) {
				String isbn= request.getParameter("isbn");
				// Borrar
				Libro milibro= new Libro(isbn);
				milibro.borrar();
				// Cargar nuevo listado
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			}else if(accion.equals("detalle")) {
				String isbn= request.getParameter("isbn");
				
				Libro libro = Libro.detalle(isbn);
				request.setAttribute("libro", libro);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/detalle.jsp");
			}else if(accion.equals("editar")) {
				String isbn= request.getParameter("isbn");
				
				Libro libro = Libro.detalle(isbn);
				request.setAttribute("libro", libro);
				// Redirigir
				despachador = request.getRequestDispatcher("libros2/editar.jsp");
			}
			// Accion=insertar
			else {
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

		// no hay accion
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