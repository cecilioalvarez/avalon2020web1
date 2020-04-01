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
import es.avalon.repositorios.LibroRepository;
import es.avalon.repositorios.jdbc.LibroRepositoryJDBC;

/**
 * Servlet implementation class Libros
 */
@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher despachador=null;
		String accion=request.getParameter("accion");
		LibroRepository repositorio= new LibroRepositoryJDBC();
		
		if (accion!=null) {
			
			if (accion.equals("formularioInsertar")) {
				
				despachador =request.getRequestDispatcher("libros2/formularioInsertar.jsp");
				
			}else if (accion.equals("insertar")){
				
				//accion=insertar
				
				//recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");

				//insertar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				repositorio.insertar(milibro);
				
				// cargar el nuevo listado
				List<Libro> listaLibros=repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);

				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
				
			}else if (accion.equals("borrar")){
				
				//accion=borrar
				
				//recepcionar
				String isbn = request.getParameter("isbn");

				//borrar
				Libro milibro = new Libro(isbn);
				repositorio.borrar(milibro);
				
				// cargar el nuevo listado				
				List<Libro> listaLibros=repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);

				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
				
			} else if (accion.equals("verDetalle")){
				
				// accion=verDetalle
				String isbn = request.getParameter("isbn");
				Libro libro=repositorio.buscarIsbn(isbn);
				request.setAttribute("libro", libro);
				
				despachador =request.getRequestDispatcher("libros2/verDetalle.jsp");
				
			} else if(accion.equals("editar")) {
				
				// accion=editar
				String isbn = request.getParameter("isbn");
				Libro milibro = repositorio.buscarIsbn(isbn);
				request.setAttribute("milibro", milibro);
				despachador =request.getRequestDispatcher("libros2/editar.jsp");

			} else if(accion.equals("salvar")){
				
				// accion=salvar
				
				// recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");

				// salvar
				Libro libro = new Libro(isbn, titulo, autor, precio, categoria);
				repositorio.salvar(libro);
				
				// cargar el nuevo listado
				List<Libro> listaLibros=repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);

				// redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");

			} else {
				
			}
			
		} else {
			
			List<Libro> listaLibros=new ArrayList<Libro>();
			listaLibros=repositorio.buscarTodos();
			
			despachador=request.getRequestDispatcher("libros2/listaLibros.jsp");
			request.setAttribute("listaLibros", listaLibros);
			
		}
		
		// redirige al jsp
		despachador.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
