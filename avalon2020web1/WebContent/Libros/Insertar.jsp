<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String ISBN=request.getParameter("ISBN");
String titulo=request.getParameter("titulo");
String autor=request.getParameter("autor");
int precio=Integer.parseInt(request.getParameter("precio"));
String categoria=request.getParameter("categoria");

Libro addlibro = new Libro(ISBN, titulo, autor, precio, categoria);

addlibro.insertar();
response.sendRedirect("ListaLibros.jsp");
%>
