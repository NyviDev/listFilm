<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Logar</h1>
	<form action="Control" method="post">
	Login: <input type="text" name="login"> <br>
	Senha: <input type="password" name="senha"> <br>
	<input type="hidden" name="acao" value="UsuarioLogar"> <br>
	<input type="hidden" name="nextPage" value="/feed.jsp">
	<input type="submit" value="Enviar">
	${msg}
	</form>
	
	<p><a href="/listfilm/registro.html">Registrar-se</a></p>

</body>
</html>