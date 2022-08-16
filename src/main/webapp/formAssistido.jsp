<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Seja bem-vindo: ${usuario.nome}</h1>

	<form action="/listfilm/Control" method="get">
		<h2>${filme.titulo}</h2>
		<p>${filme.id }</p>
		<p>Diretor: ${filme.diretor}</p>
		<p>Ano de Lançamento: ${filme.ano_lancamento}</p>
		<p>Genero: ${filme.genero}</p>
		<p>Nacionalidade: ${filme.nacionalidade}</p>
		Avaliação <input type="number" name="avaliacao">
		<input type="hidden" name="id_filme" value="${filme.id}"> <input
			type="hidden" name="acao" value="AssistidoAdicionar"> <input
			type="hidden" name="nextPage" value="/feed.jsp"> <input
			type="submit" value="Enviar">
	</form>

</body>