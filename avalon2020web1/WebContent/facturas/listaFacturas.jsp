<%@page import="java.util.List"%>
<%@page import="es.avalon.dominio.Factura"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Factura> lista = (List<Factura>) request.getAttribute("listaFacturas");
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
			<th>numero</th>
			<th>concepto</th>
			<th>importe</th>
		</tr>
		<%
			for (Factura f : lista) {
		%>
		<tr>
			<td><%=f.getNumero()%></td>
			<td><%=f.getConcepto()%></td>
			<td><%=f.getImporte()%></td>	
		</tr>
		<%
			}
		%>
	</table>
	<a href="ServletFacturas?accion=formularioInsertar">insertar</a>

</body>
</html>