package es.avalon.controladores;

import java.io.IOException;
import java.util.*;

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
		//List = interfaz, es más flexible ArrayList es una clase
		
		
		//crear el desahachor y decir a donde vamos
		RequestDispatcher despachador=request.getRequestDispatcher("libros2/Listalibros.jsp");
		String accion=request.getParameter("accion");
		//hay accion
		if (accion!=null) {
			if (accion.equals("FormularioInsertar")){
				despachador= request.getRequestDispatcher("libros2/FormularioInsertar.jsp");
				
			}else if(accion.equals("borrar")) {
				String isbn=request.getParameter("ISBN");
				Libro libro= new Libro(isbn);
				libro.borrar(); 
				//cargo de nuevo el listado
				List<Libro> listalibros= new ArrayList<Libro>();
				listalibros= Libro.buscarTodos();
				request.setAttribute("Listalibros", listalibros);
			}else if(accion.equals("detalle")){
				despachador= request.getRequestDispatcher("libros2/detalle.jsp");
		
			}else if(accion.equals("editar")){
				String isbn=request.getParameter("ISBN");		
				Libro libro=Libro.buscarPorISBN(isbn); 
				request.setAttribute("libro", libro);
				despachador= request.getRequestDispatcher("libros2/editar.jsp");
				
						
			}else if (accion.equals("salvar")){
				
				String isbn=request.getParameter("ISBN");
				String titulo=request.getParameter("titulo");
				String autor=request.getParameter("autor");
				int precio=Integer.parseInt(request.getParameter("precio"));
				String categoria=request.getParameter("categoria");
				//genero libro
		
				Libro libro= new Libro (isbn, titulo, autor, precio, categoria);
				libro.actualizar();
				//cargo nuevo listado con datos nuevos
				
				List<Libro> listalibros= new ArrayList<Libro>();
				listalibros= Libro.buscarTodos();
				request.setAttribute("Listalibros", listalibros);
				despachador= request.getRequestDispatcher("libros2/Listalibros.jsp");
			}
			else {

				//accion= insertar
				//recojo el dato porque insertar.jsp no sirve es un fichero malo
				String isbn=request.getParameter("ISBN");
				String titulo=request.getParameter("titulo");
				String autor=request.getParameter("autor");
				int precio=Integer.parseInt(request.getParameter("precio"));
				String categoria=request.getParameter("categoria");
			
				//gerno libro y lo inserto
				Libro libro= new Libro (isbn, titulo, autor, precio, categoria);
				
				libro.insertar();
				//cargar nuevo listado
				List<Libro> listalibros= new ArrayList<Libro>();
				listalibros= Libro.buscarTodos();
				request.setAttribute("Listalibros", listalibros);
				//redirigir
				despachador= request.getRequestDispatcher("libros2/Listalibros.jsp");
			}
			
		
		
		
		//no accion
		}else {
			List<Libro> listalibros= new ArrayList<Libro>();
			listalibros= Libro.buscarTodos();
			despachador= request.getRequestDispatcher("libros2/Listalibros.jsp");
			request.setAttribute("Listalibros", listalibros);
		}
		
		//asignar datos adicionales
		
		//reenvio
		despachador.forward(request,response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
