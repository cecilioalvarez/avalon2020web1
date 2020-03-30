<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String ISBN=request.getParameter("ISBN");
Libro libro=new Libro(ISBN);

libro.buscarPorISBN(ISBN);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>
	isbn:<%=libro.getIsbn()%>	
</p>
<p>
	precio:<%=libro.getPrecio()%>	
</p>
<p>
	autor:<%=libro.getAutor()%>	
</p>
<p>
	titulo:<%=libro.getTitulo()%>
</p>
<p>
	categoria:<%=libro.getCategoria()%>
</p>
	


</body>
</html>