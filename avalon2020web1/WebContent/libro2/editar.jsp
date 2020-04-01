<%@page import="es.avalon.dominio.Libro"%>
<%
Libro libro= Libro.detalle(request.getParameter("isbn"));
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletLibros">
		<p>isbn:<input type="text" name="precio" value="<%=libro.getIsbn()%>/>"/></p>
		<p>titulo:<input type="text" name="precio" value="<%=libro.getTitulo()%>/>"/></p>
		<p>autor:<input type="text" name="autor" value="<%=libro.getAutor()%>/>"/></p>
		<p>precio:<input type="text" name="precio" value="<%=libro.getPrecio()%>/>"/></p>
		<p>categoria:<input type="text" name="categoria" value="<%=libro.getCategoria()%>/>"/></p>
		<input type="submit" value="Enviar" />
		<input type="hidden" name="accion" value="salvar"/>
	</form>

</body>
</html>