<%@page import="java.io.PrintWriter"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String isbn=request.getParameter("ISBN");
String titulo=request.getParameter("titulo");
String autor=request.getParameter("autor");
int precio=Integer.parseInt(request.getParameter("precio"));
String categoria=request.getParameter("categoria");
Libro libro= new Libro (isbn, titulo, autor, precio, categoria);
libro.actualizar();
response.sendRedirect("Listalibros.jsp");
%>
</body>
</html>