<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletLibros" method="POST" >
<p> ISBN:<input type="text" name ="ISBN"/></p>
<p> Titulo:<input type="text" name ="titulo"/></p>
<p> Autor:<input type="text" name ="autor"/></p>
<p> Precio:<input type="text" name ="precio"/></p>
<p> Categoria:<input type="text" name ="categoria"/></p>

<input type= "hidden" name ="accion" value="insertar"/>
<input type= "submit" value="enviar"/>
</form>
</body>
</html>




