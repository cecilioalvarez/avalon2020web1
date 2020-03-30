<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
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
		<%
			for (Libro l : lista) {
		%>
		<tr>
			<td><%=l.getIsbn()%></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getAutor()%></td>
			<td><%=l.getPrecio()%></td>
			<td><%=l.getCategoria()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>