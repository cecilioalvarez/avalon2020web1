<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.avalon.dominio.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String ISBN=request.getParameter("ISBN");
String titulo=request.getParameter("titulo");
String autor=request.getParameter("autor");
int precio=Integer.parseInt(request.getParameter("precio"));
String categoria=request.getParameter("categoria");

Libro addlibro = new Libro(ISBN, titulo, autor, precio, categoria);

addlibro.actualizar();
response.sendRedirect("ListaLibros.jsp");
%>
</body>
</html>