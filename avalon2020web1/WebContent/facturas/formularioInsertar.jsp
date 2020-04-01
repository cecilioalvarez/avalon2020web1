<%@ page language="java" contentType="text/html; charset=UTF-8)"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletFacturas" method="POST">
		<p>
			numero:<input type="text" name="numero" />
		</p>
		<p>
			concepto:<input type="text" name="concepto" />
		</p>
		<p>
			importe:<input type="text" name="importe" />
		</p>
		<p>
		<input type="hidden" name="accion" value="insertar" />
		<input type="submit" name="enviar" />
		</p>
</body>
</html>