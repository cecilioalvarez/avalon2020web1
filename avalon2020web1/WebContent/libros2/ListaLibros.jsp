
<%@ page import="es.avalon.dominio.Libro" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Libro> lista = new ArrayList<Libro>();
lista = (ArrayList<Libro>) request.getAttribute("listaLibros");
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
			<th>categoria</th>
		</tr>
		<% for (Libro l : lista) { %>
		<tr>
			<td><%=l.getIsbn()%></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getAutor()%></td>
			<td><%=l.getPrecio()%></td>
			<td><%=l.getCategoria()%></td>
			<td><a href="Borrar.jsp?isbn=<%= l.getIsbn()%>">borrar</a></td>
			<td><a href="verDetalle.jsp?isbn=<%=l.getIsbn()%>">detalle</a></td>
			<td><a href="formularioEditar.jsp?isbn=<%=l.getIsbn()%>">editar</a></td>
		</tr>
		<%}%>
	</table>
	<a href="formularioInsertar.jsp">insertar</a>
</body>
</html>