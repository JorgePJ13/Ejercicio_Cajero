<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transferencia de Dinero</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="cuerpo">
		<h2>Transferencia</h2>
		<form action="Transferir" method="post">
			Cantidad: <input type="number" name="cantidad" placeholder="500€"
				required /> <br> <br> 
			Cuenta Destino: <input type="text" name="cuentaTransferencia" placeholder="ES35..." required /> <br> <br>
			<input type="submit" value="Transferir"> <br> <br>
		</form>
		<a href="menu.jsp">Volver</a>
	</div>
</body>
</html>