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


@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher despachador = null;
		String accion = request.getParameter("accion");
		LibroRepository repositorio = new LibroRepositoryJDBC();
		
		//algun tipo de accion
		if (accion!=null) {
			
			if (accion.equals("formularioInsertar")) {
				
				despachador = request.getRequestDispatcher("libros2/formularioInsertar.jsp");	
				
			} else if (accion.equals("borrar")){
				
				//Recepcionar
				String isbn = request.getParameter("isbn");	
				
				//Eliminar
				Libro milibro = new Libro(isbn);
				
				repositorio.eliminar(milibro);
				
				//Cargar el nuevo listado
				List<Libro> listaLibros = repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				
				//Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
				
			} else if (accion.equals("detalle")) {
				
				String isbn = request.getParameter("isbn");
				
				Libro libro = repositorio.buscarPorISBN(isbn);
				request.setAttribute("libro", libro);
				
				
				despachador = request.getRequestDispatcher("libros2/verDetalle.jsp");	
			
			} else if (accion.equals("editar")) {
				
				String isbn = request.getParameter("isbn");
				
				Libro libro = repositorio.buscarPorISBN(isbn);
				request.setAttribute("libro", libro);
				
				despachador = request.getRequestDispatcher("libros2/formularioEditar.jsp");
				
			} else if (accion.equals("actualizar")) {
				
				//Recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");
				
				//Actualizar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				
				repositorio.actualizar(milibro);
				
				//Cargar el nuevo listado
				List<Libro> listaLibros = repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				
				//Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
				
				
				
			} else {
				//accion de insertar
				
				//Recepcionar
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				int precio = Integer.parseInt(request.getParameter("precio"));
				String categoria = request.getParameter("categoria");
				
				//Insertar
				Libro milibro = new Libro(isbn, titulo, autor, precio, categoria);
				
				repositorio.insertar(milibro);
				
				//Cargar el nuevo listado
				List<Libro> listaLibros = repositorio.buscarTodos();
				request.setAttribute("listaLibros", listaLibros);
				
				//Redirigir
				despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			} 
		//no hay action	
		} else {
			List<Libro> listaLibros = new ArrayList<Libro>();
			
			listaLibros = repositorio.buscarTodos(); 
			
			despachador = request.getRequestDispatcher("libros2/listaLibros.jsp");
			//asigno datos adicionales
			request.setAttribute("listaLibros", listaLibros);
			
			
		}
		
		//reenvio
		despachador.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
