<%@page import="java.io.PrintWriter"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@page import="java.util.*"%>
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
//String isbn=request.getParameter("ISBN");		
Libro libro=(Libro)request.getAttribute("libro");
//Libro libro=Libro.buscarPorISBN(isbn); 
%>

<p> isbn: <%=libro.getIsbn()%></p>
<p> titulo:<%=libro.getTitulo()%></p>
<p> autor:<%=libro.getAutor()%></p>
<p> precio: <%=libro.getPrecio()%></p>
<p> categoria: <%=libro.getCategoria()%></p>

</body>
</html>