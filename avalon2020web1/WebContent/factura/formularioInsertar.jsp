<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletFactura" method="post">
		<p>numero:<input type="text" name="numero" /></p>
		<p>concepto:<input type="text" name="concepto" /></p>
		<p>importe:<input type="text" name="importe" /></p>
		<input type="hidden" name="accion" value="insertar"/>
		<input type="submit" value="Enviar" />
	</form>

</body>
</html>