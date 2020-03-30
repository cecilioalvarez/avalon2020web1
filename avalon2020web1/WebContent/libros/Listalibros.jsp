<%@page import="es.avalon.dominio.Libro"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<Libro> lista= new ArrayList<Libro>();
lista =Libro.buscarTodos();
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
<td><a href="borrar.jsp?ISBN=<%= l.getIsbn() %>">borrar</a></td>
<td><a href="detalle.jsp?ISBN=<%= l.getIsbn() %>">ver detalles</a></td>
</tr>
<%} %>

</table>
<a href="FormularioInsertar.jsp">insertar</a>
</body>
</html>