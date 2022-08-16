
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Desejo</title>
</head>
<body>

	<h2>Lista de Desejos</h2>
	<a href="/listfilm/Control?acao=FilmeTelaListar">Voltar para Página
		Principal</a>
	<form action="/listfilm/Control" method="get">
		Procurar: <input type="text" name="titulo"> <input
			type="hidden" name="acao" value="DesejadoListar"> <input
			type="hidden" name="nextPage" value="/listaDeDesejo.jsp"> <input
			type="submit" value="Enviar">
	</form>

	<c:forEach var="desejado" items="${desejados}">
		<c:forEach var="filmeIf" items="${filmes}">
			<c:if test="${desejado.filme.id == filmeIf.id}">
				<p>${desejado.id}</p>
				<h2>${filmeIf.titulo}</h2>
				<p>${filmeIf.id }</p>
				<p>Diretor: ${filmeIf.diretor}</p>
				<p>Ano de Lançamento: ${filmeIf.ano_lancamento}</p>
				<p>Genero: ${filmeIf.genero}</p>
				<p>Nacionalidade: ${filmeIf.nacionalidade}</p>
				<a href="/listfilm/Control?acao=AssistidoTelaAdicionar&id=${filmeIf.id}">Marcar
			como Assistido</a>
				<br>
				<a href="/listfilm/Control?acao=DesejadoRemover&id=${desejado.id}">Remover
					da Lista</a>

				<hr>
			</c:if>
		</c:forEach>
	</c:forEach>




</body>
</html>


