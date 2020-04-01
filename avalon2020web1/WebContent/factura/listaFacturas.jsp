<%@page import="java.util.List"%>
<%@page import="es.avalon.dominio.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Factura> lista =(List<Factura>) request.getAttribute("listaFacturas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lista factura</title>
</head>
<body>
	<table>
		<tr>
			<th>Numero</th>
			<th>Concepto</th>
			<th>Importe</th>
		</tr>
		<% for (Factura f: lista ) { %>
		<tr>
			<td><%=f.getNumero()%></td>
			<td><%=f.getConcepto()%></td>
			<td><%=f.getImporte()%></td>
			
			<td><a href="ServletFactura?numero=<%=f.getNumero()%>&accion=borrar">borrar</a></td>
			
		</tr>	
		<% } %>
	</table>
	<a href="ServletFactura?accion=formularioInsertar">insertar</a>
	
</body>
</html>