<%@page import="java.util.ArrayList"%>
<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%
String ISBN=request.getParameter("ISBN");
Libro libro=Libro.buscarPorISBN(ISBN);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="salvar.jsp" method="GET">
		<p>
			ISBN:<input type="text" name="ISBN"  value="<%=libro.getIsbn()%>"/>
		</p>
		<p>
			Autor:<input type="text" name="titulo"  value="<%=libro.getAutor()%>" />
		</p>
		<p>
			Titulo:<input type="text" name="autor"  value="<%=libro.getTitulo()%>" />
		</p>
		<p>
			Precio:<input type="number" name="precio"   value="<%=libro.getPrecio()%>"/>
		</p>
		<p>
			Categoria:<input type="text" name="categoria"  value="<%=libro.getCategoria()%>"/>
		</p>
		<input type="submit" name="submit" />
	</form>

</body>
</html>