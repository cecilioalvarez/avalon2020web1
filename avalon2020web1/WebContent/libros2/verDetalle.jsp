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
		Libro milibro =(Libro) request.getAttribute("libro");
	%>
	
	<p>ISBN = <%=milibro.getIsbn()%></p>
	<p>TITULO = <%=milibro.getTitulo()%></p>
	<p>AUTOR = <%=milibro.getAutor()%></p>
	<p>PRECIO = <%=milibro.getPrecio()%></p>
	<p>CATEGORIA = <%=milibro.getCategoria()%></p>
	
</body>
</html>