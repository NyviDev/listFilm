
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/listfilm/Control" method="get">
	Título <input type="text" name="titulo" value="${filme.titulo}"> <br>
	Diretor <input type="text" name="diretor" value="${filme.diretor}"> <br>
	Ano de lançamento: <input type="text" name="ano_lancamento" value="${filme.ano_lancamento}"><br>
	Genero <input type="text" name="genero" value="${filme.genero}"> <br>
	Nacionalidade <input type="text" name="nacionalidade" value="${filme.nacionalidade}"> <br>
	<input type="hidden" name="id" value="${filme.id}">
	<input type="hidden" name="acao" value="FilmeAlterar">
	<input type="hidden" name="nextPage" value="/feed.jsp">
	<input type="submit" value="Enviar">
	</form>

</body>

