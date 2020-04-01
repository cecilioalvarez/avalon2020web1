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
 * aportan informacion clave al servidor
 */
// http://localhost:8080/avalon2020web1/ServletLibros
@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher despachador = null;
		String accion = request.getParameter("accion");

		// hay algun tipo de accion
		if (accion != null) {

			if (accion.equals("formularioInsertar")) {

				despachador = request.getRequestDispatcher("libros2/formularioInsertar.jsp");
			} else if (accion.equals("borrar")) {

				String isbn = request.getParameter("isbn");
				Libro milibro = new Libro(isbn);
				milibro.borrar();
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");

			}

			else if (accion.equals("detalle")) {

				String isbn = request.getParameter("isbn");

				Libro libro = Libro.buscarPorISBN(isbn);
				request.setAttribute("libro", libro);

				despachador = request.getRequestDispatcher("libros2/detalle.jsp");

			}
			
			else if (accion.equals("editar")) {

				String isbn = request.getParameter("isbn");

				Libro libro = Libro.buscarPorISBN(isbn);
				request.setAttribute("libro", libro);

				despachador = request.getRequestDispatcher("libros2/editar.jsp");

			}
			else if (accion.equals("salvar")) {

				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				milibro.salvar();
				
				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");

			}
			else {

				// accion=insertar

				// recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");

				// insertar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				milibro.insertar();

				// cargar el nuevo listado

				List<Libro> listaLibros = Libro.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			}

			// no hay accion
		} else {

			List<Libro> listaLibros = new ArrayList<Libro>();

			listaLibros = Libro.buscarTodos();

			despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			request.setAttribute("listaLibros", listaLibros);
		}

		// redirige al jsp
		despachador.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
