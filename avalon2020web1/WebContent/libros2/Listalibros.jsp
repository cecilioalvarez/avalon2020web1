<%@page import="es.avalon.dominio.Libro"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Libro> lista= (List<Libro>) request.getAttribute("Listalibros");
//lista =Libro.buscarTodos();
%>

<table>
<tr>
<th> ISBN</th>
<th> Titulo</th>

<th> Autor</th>
<th> Precio</th>
<th> Categoria</th>
</tr>
<% for (Libro l: lista) {%>
<tr>
<td><%= l.getIsbn() %></td>
<td><%= l.getTitulo() %></td>
<td><%= l.getAutor() %></td>
<td><%= l.getPrecio() %></td>
<td><%= l.getCategoria() %></td>
<td><a href="ServletLibros?ISBN=<%= l.getIsbn() %>&accion=borrar">borrar</a></td>
<td><a href="ServletLibros?ISBN=<%= l.getIsbn() %>&accion=detalle">ver detalles</a></td>
<td><a href="ServletLibros?ISBN=<%= l.getIsbn() %>&accion=editar">editar</a></td>
</tr>
<%} %>

</table>
<a href="ServletLibros?accion=FormularioInsertar">insertar</a>
</body>
</html>