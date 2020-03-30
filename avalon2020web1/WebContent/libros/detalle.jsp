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
PrintWriter pw= response.getWriter();
String isbn=request.getParameter("ISBN");		
Libro libro= new Libro(isbn);
libro.buscarPorISBN(isbn); 

pw.println(libro.getIsbn());
pw.println(libro.getTitulo());
pw.println(libro.getAutor());
pw.println(libro.getPrecio());
pw.println(libro.getCategoria());
%>
</body>
</html>