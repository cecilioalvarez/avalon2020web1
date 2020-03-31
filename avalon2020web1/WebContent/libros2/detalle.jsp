<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle</title>
</head>
<body>
	<%
		Libro libro = (Libro) request.getAttribute("libro");
	%>

	<p>ISBN: <%=libro.getIsbn()%></p>

	<p>Titulo: <%=libro.getTitulo()%></p>

	<p>Autor: <%=libro.getAutor()%></p>

	<p>Precio: <%=libro.getPrecio()%></p>

	<p>Categoria: <%=libro.getCategoria()%></p>

</body>
</html>