<%@page import="es.avalon.dominio.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% 
   Libro libro = (Libro) request.getAttribute("libro");
   %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletLibros">
<p>
ISBN: <input type="text" name="isbn" value = "<%= libro.getIsbn() %>"/>
</p>
<p>
Titulo: <input type="text" name="titulo" value = "<%= libro.getTitulo() %>"/>
</p>
<p>
Autor: <input type="text" name="autor" value = "<%= libro.getAutor() %>"/>
</p>
<p>
Precio: <input type="text" name="precio" value = "<%= libro.getPrecio() %>"/>
</p>
<p>
Categoria: <input type="text" name="categoria" value = "<%= libro.getCategoria() %>"/>
</p>

<input type="hidden" name="accion" value="actualizar"/>
<input type="submit" value="enviar"/>
</form>

</body>
</html>


