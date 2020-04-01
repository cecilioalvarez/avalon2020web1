<%@page import="es.avalon.dominio.Factura"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	List<Factura> milista = (List<Factura>) request.getAttribute("listaFacturas");
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
			<th>NUMERO</th>
			<th>CONCEPTO</th>
			<th>IMPORTE</th>
		</tr>

		<tr>
			<%
				for (Factura f : milista) {
			%>
		</tr>

		<tr>
			<td><%=f.getNumero()%></td>
			<td><%=f.getConcepto()%></td>
			<td><%=f.getImporte()%></td>
		</tr>

		<%
			}
		%>
	</table>
	<a href="ServletFactura?accion=formularioInsertar">insertar</a>


</body>
</html>