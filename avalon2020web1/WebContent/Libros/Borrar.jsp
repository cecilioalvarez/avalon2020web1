<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String ISBN=request.getParameter("ISBN");

Libro removelibro=new Libro(ISBN);

removelibro.borrar();

response.sendRedirect("ListaLibros.jsp");
%>
</body>
</html>