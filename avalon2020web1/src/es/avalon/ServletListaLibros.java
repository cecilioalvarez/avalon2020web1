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

@WebServlet("/ServletListaLibros")
public class ServletListaLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		Libro milibro=new Libro("1","java1","cecilio",15,"java");
		Libro milibro2=new Libro("2","html15","pepe",20,"html");
		Libro milibro3=new Libro("3","java2","ines",35,"java");
		Libro milibro4=new Libro("4","javaexperto","juan",25,"java");
		Libro milibro5=new Libro("5","python","juan",20,"programacion");
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		libros.add(milibro);
		libros.add(milibro2);
		libros.add(milibro3);
		libros.add(milibro4);
		libros.add(milibro5);
	
		pw.println("<html><body>");
		
		for (Libro l: libros) {
			pw.println("<p>");
			pw.println(l.getIsbn());
			pw.println(l.getTitulo());
			pw.println(l.getAutor());
			pw.println(l.getPrecio());
			pw.println(l.getCategoria());	
			pw.println("</p>");
		}
		
		
		pw.println("</body></html>");
		pw.close();
		
	}


}
