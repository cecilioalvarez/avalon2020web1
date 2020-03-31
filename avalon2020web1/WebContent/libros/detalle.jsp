<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Libro l = Libro.detalle(request.getParameter("isbn"));
%>
	<p>
		ISBN:
		<%=l.getIsbn()%>
	</p>

	<p>
		Titulo:
		<%=l.getTitulo()%>
	</p>

	<p>
		Autor:
		<%=l.getAutor()%>
	</p>

	<p>
		Precio:
		<%=l.getPrecio()%>
	</p>

	<p>
		Categoria:
		<%=l.getCategoria()%>
	</p>
</body>
</html>