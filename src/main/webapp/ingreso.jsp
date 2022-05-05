<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de Dinero</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="cuerpo">
		<h2>Ingreso</h2>
		<form action="Ingresar" method="post">
			Cantidad: <input type="number" name="cantidad" placeholder="500€" required /> <br> <br>
			<input type="submit" value="Ingresar"> <br> <br>
		</form>
		<a href="menu.jsp">Volver</a>
	</div>
</body>
</html>