<%@page import="java.io.PrintWriter"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%
//nos podemos quedar simplemente cn el java sin importarnos lo de html
PrintWriter pw= response.getWriter();
		String isbn=request.getParameter("ISBN");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		int precio=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
	
		Libro libro= new Libro (isbn, titulo, autor, precio, categoria);
		
		libro.insertar();
		response.sendRedirect("Listalibros.jsp");
%>
