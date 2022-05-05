<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="cuerpo">
		<h2>Extracción</h2>
		<form action="Extraer" method="post">
			Cantidad: <input type="number" name="cantidad" placeholder="500€" required /> <br> <br> 
			<input type="submit" value="Extraer"> <br> <br>
		</form>
		<a href="menu.jsp">Volver</a>
	</div>
</body>
</html>