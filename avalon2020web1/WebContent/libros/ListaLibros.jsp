
<%@page import="es.avalon.dominio.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Libro> lista = new ArrayList<Libro>();
lista = Libro.buscarTodos();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ISBN</th>
			<th>titulo</th>
			<th>autor</th>
			<th>precio</th>
			<th>Categoria</th>
		</tr>
		<% for (Libro l:lista ) { %>
		<tr>
			<td><%=l.getIsbn()%></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getCategoria()%></td>
			<td><%=l.getAutor()%></td>
			<td><%=l.getPrecio()%></td>
			<td><a href="borrar.jsp?isbn=<%=l.getIsbn()%>">borrar</a></td>
		</tr>	
		<% } %>
	</table>
	<a href="formularioInsertar.jsp">insertar</a>
</body>
</html>