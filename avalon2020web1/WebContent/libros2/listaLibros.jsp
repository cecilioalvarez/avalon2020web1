<%@page import="java.util.List"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Libro> milista = (List<Libro>) request.getAttribute("listaLibros");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
			<td><a href="borrar.jsp?isbn=<%=l.getIsbn()%>"> Borrar </a></td>
			<td><a href="verDetalle.jsp?isbn=<%=l.getIsbn()%>"> Ver
					detalle </a></td>
			<td><a href="editar.jsp?isbn=<%=l.getIsbn()%>"> Editar </a></td>
		</tr>

		<%
			}
		%>
	</table>
	<a href="ServletLibros?accion=formularioInsertar">insertar</a>

</body>
</html>