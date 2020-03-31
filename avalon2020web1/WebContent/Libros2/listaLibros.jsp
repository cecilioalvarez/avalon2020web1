
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@page import="java.util.ArrayList"%>
<%
List<Libro> lista=(List<Libro>) request.getAttribute("listaLibros");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%

	lista = Libro.buscarTodos();
	%>
	<table>
		<tr>
			<th>ISBN</th>
			<th>titulo</th>
			<th>precio</th>
			<th>autor</th>
			<th>categoria</th>
		</tr>
		<%for(Libro l:lista){ %>
		<tr>
			<td><%=l.getIsbn()%></td>
			<td><%=l.getPrecio()%></td>
			<td><%=l.getAutor()%></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getCategoria()%></td>
			<td><a href="Borrar.jsp?ISBN=<%=l.getIsbn() %>">borrar</a></td>
			<td><a href="VerDetalle.jsp?ISBN=<%=l.getIsbn() %>">Ver a detalle</a></td>
			<td><a href="Editar.jsp?ISBN=<%=l.getIsbn() %>">editar</a></td>
		</tr>
		<%} %>
	
	
	</table>
	<a href="ServletLibros?accion=FormularioInsertar">Insertar</a>

</body>
</html>