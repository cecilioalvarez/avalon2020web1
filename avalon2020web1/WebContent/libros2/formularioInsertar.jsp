<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletLibros" method="post">
<p>
ISBN: <input type="text" name="isbn"/>
</p>
<p>
Titulo: <input type="text" name="titulo"/>
</p>
<p>
Autor: <input type="text" name="autor"/>
</p>
<p>
Precio: <input type="text" name="precio"/>
</p>
<p>
Categoria: <input type="text" name="categoria"/>
</p>

<input type="hidden" name="accion" value="insertar"/>
<input type="submit" value="aceptar"/>
</form>

</body>
</html>