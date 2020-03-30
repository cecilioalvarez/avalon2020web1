<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Libro l= Libro.buscarPorIsbn(request.getParameter("isbn"));
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
			<p><td>ISBN: <%=l.getIsbn()%></td></p>
			<p><td>TITULO: <%=l.getTitulo()%></td></p>
			<p><td>AUTOR: <%=l.getAutor()%></td></p>
			<p><td>PRECIO: <%=l.getPrecio()%></td></p>
			<p><td>CATEGORIA: <%=l.getCategoria()%></td></p>
		</tr>

	</table>
</body>
</html>