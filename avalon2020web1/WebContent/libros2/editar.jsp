<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Libro milibro= (Libro)request.getAttribute("milibro");
	%>

<form action="ServletLibros">
	<p>
		ISBN <input type "text" name="isbn" value="<%=milibro.getIsbn()%>" />
	</p>
	<p>
		TITULO <input type "text" name="titulo"
			value="<%=milibro.getTitulo()%>" />
	</p>
	<p>
		AUTOR <input type "text" name="autor" value="<%=milibro.getAutor()%>" />
	</p>
	<p>
		PRECIO <input type "text" name="precio"
			value="<%=milibro.getPrecio()%>" />
	</p>
	<p>
		CATEGORIA <input type "text" name="categoria"
			value="<%=milibro.getCategoria()%>" />
	</p>
<p>	
<input type="hidden" name="accion" value="salvar"/>
<input type="submit" value="enviar" />
</p>

</form>
</body>
</html>