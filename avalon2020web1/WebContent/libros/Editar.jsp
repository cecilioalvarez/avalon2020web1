<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Libro l = Libro.buscarPorIsbn(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Salvar.jsp">
		<p>
			isbn:<input type="text" name="isbn" value="<%=l.getIsbn()%>" />
		</p>
		<p>
			Titulo: <input type="text" name="titulo" value="<%=l.getTitulo()%>" />
		</p>
		<p>
			Autor: <input type="text" name="autor" value="<%=l.getAutor()%>" />
		</p>
		<p>
			Precio:<input type="text" name="precio" value="<%=l.getPrecio()%>" />
		</p>
		<p>
			Categoria: <input type="text" name="categoria"
				value="<%=l.getCategoria()%>" />
		</p>
		<p>
			<input type="submit" name="aceptar" />
		</p>
	</form>
</body>
</html>