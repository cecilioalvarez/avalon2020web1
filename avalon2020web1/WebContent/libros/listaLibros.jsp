<%@page import="java.util.ArrayList"%>
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
		ArrayList<Libro> milista = new ArrayList<Libro>();

	milista = Libro.buscarTodos();
	%>
	<table>
		<tr>
			<th>ISBN</th>
			<th>TITULO</th>
			<th>AUTOR</th>
			<th>PRECIO</th>
			<th>CATEGORIA</th>
		</tr>

		<tr>
			<%
				for (Libro l : milista) {
			%>
		</tr>

		<tr>
			<td><%=l.getIsbn()%></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getAutor()%></td>
			<td><%=l.getPrecio()%></td>
			<td><%=l.getCategoria()%></td>
			<td> <a href="borrar.jsb?isbn=<%=l.getIsbn()%>"> borrar </a></td>
		</tr>

		<%
			}
		%>
	</table>
	<a href="formularioInsertar.jsp">insertar</a>

</body>
</html>