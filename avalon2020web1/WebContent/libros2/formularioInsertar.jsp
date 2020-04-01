<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletLibros" method="post">
		<p>isbn:<input type="text" name="isbn" /></p>
		<p>titulo:<input type="text" name="titulo" /></p>
		<p>autor:<input type="text" name="autor" /></p>
		<p>precio:<input type="text" name="precio" /></p>
		<p>categoria:<input type="text" name="categoria" /></p>
		<input type="hidden" name="accion" value="insertar"/>
		<input type="submit" value="Enviar" />
	</form>

</body>
</html>