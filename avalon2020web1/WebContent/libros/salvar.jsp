<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String isbn=request.getParameter("isbn");
String titulo=request.getParameter("titulo");
String autor=request.getParameter("autor");
int precio= Integer.parseInt(request.getParameter("precio"));
String categoria=request.getParameter("categoria");

Libro milibro= new Libro (isbn,titulo,autor,precio,categoria);
milibro.salvarr();
response.sendRedirect("ListaLibros.jsp");
%>