<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validación de Cuenta</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<center>
		<p style="color: red;">${sessionScope.error}</p>
		<h2>Introduce tú numero de cuenta para acceder a las operaciones</h2>
		<form action="Validar" method="post">
			Número de Cuenta: <input type="number" name="numeroCuenta" placeholder="ES..." required /> <br> <br> 
			<input type="submit" value="Entrar" />
		</form>
	</center>
</body>
</html>