<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletFactura" method="POST" />
	<p>
		NUMERO:<input type "text" name="numero" />
	</p>
	<p>
		CONCEPTO:<input type "text" name="concepto" />
	</p>
	<p>
		IMPORTE:<input type "text" name="importe" />
	</p>

	<p>
		<input type="hidden" name="accion" value="insertar" /> 
		<input type="submit" value="enviar" />
	</p>
</body>
</html>