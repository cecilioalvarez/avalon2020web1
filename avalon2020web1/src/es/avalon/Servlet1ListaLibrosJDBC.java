package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;


@WebServlet("/Servlet1ListaLibrosJDBC")
public class Servlet1ListaLibrosJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter pw=response.getWriter(); 
			
			
			ArrayList<Libro> listalibros=new ArrayList<Libro>();
			
			listalibros=Libro.buscarTodos();
	
		

			pw.println("<html><body>");
			for(Libro l:listalibros) {
			pw.println("<p>");
			pw.println(l.getIsbn());
			pw.println(l.getTitulo());
			pw.println(l.getAutor());
			pw.println(l.getPrecio());
			pw.println(l.getCategoria());
			
			//ahora estoy poniendo este tratando de mejorar el que hemos hecho de borrar
			//dando la opcion a borrar
			pw.println("<a href='Servlet3removeLibrosJDBC?ISBN="+l.getIsbn()+"'>borrar</a>");
			pw.println("</p>");

			}
			pw.println("</body></html>");
			pw.close();
		
		}

	}
