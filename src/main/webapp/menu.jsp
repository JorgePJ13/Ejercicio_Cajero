<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="cuerpo">
		<p style="color: red;">${sessionScope.operacion}</p>
		<nav>
			<h1>Menú</h1>
			<h3>¿Qué operación desea realizar?</h3>
		</nav>
		<br> <a href="ingreso.jsp">Ingreso</a> <br> <br> <a
			href="extraccion.jsp">Extracción</a> <br> <br> <a
			href="transferencia.jsp">Transferencia</a> <br> <br> <a
			href="saldo.jsp">Ver saldo</a> <br> <br> <a
			href="movimientos.jsp">Movimientos</a> <br> <br> <a
			href="login.jsp">Cerrar Sesión</a> <br> <br>

	</div>
</body>
</html>