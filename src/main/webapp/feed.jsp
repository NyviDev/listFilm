<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<a href="Control?acao=UsuarioSair">Sair</a>
	<p><a href="/listfilm/formFilme.jsp">Adicionar Filme</a></p>
	<p><a href="/listfilm/Control?acao=DesejadoTelaListar">Ver Lista de Desejos</a></p>
	<p><a href="/listfilm/Control?acao=AssistidoTelaListar">Ver Lista de Filmes Assistidos</a></p>

	<form action="/listfilm/Control" method="get">
		Procurar: <input type="text" name="titulo">
		<input type="hidden" name="acao" value="FilmeListar">
		<input type="hidden" name="nextPage" value="/feed.jsp">
		<input type="submit" value="Enviar">
	</form>


	<c:forEach var="filme" items="${filmes}">
		<h2>${filme.titulo}</h2>
		<p>${filme.id }</p>
		<p>Diretor: ${filme.diretor}</p>
		<p>Ano de Lançamento: ${filme.ano_lancamento}</p>
		<p>Genero: ${filme.genero}</p>
		<p>Nacionalidade: ${filme.nacionalidade}</p>

		<form action="/listfilm/Control" method="get">
			<input type="hidden" name="id_filme" value=${ filme.id }> <input
				type="hidden" name="acao" value="DesejadoAdicionar">
				 <input type="hidden" name="nextPage" value="/feed.jsp">
				<input type="submit" value="Lista de Desejo">
		</form>

		<a href="/listfilm/Control?acao=AssistidoTelaAdicionar&id=${filme.id}">Marcar
			como Assistido</a>
		<br>
		<a href="/listfilm/Control?acao=FilmeTelaAlterar&id=${filme.id}">Alterar
			filme</a>
		<br>

	</c:forEach>



</body>
</html>
