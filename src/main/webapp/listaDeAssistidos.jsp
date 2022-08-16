
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Assistidos</title>
</head>
<body>

	<h2>Lista de Assistidos</h2>
	<a href="/listfilm/Control?acao=FilmeTelaListar">Voltar para Página
		Principal</a>
	<form action="/listfilm/Control" method="get">
		Procurar: <input type="text" name="titulo"> <input
			type="hidden" name="acao" value="AssistidoListar"> <input
			type="hidden" name="nextPage" value="/listaDeAssistidos.jsp"> <input
			type="submit" value="Enviar">
	</form>

	<c:forEach var="assistido" items="${assistidos}">
		<c:forEach var="filmeIf" items="${filmes}">
			<c:if test="${assistido.filme.id == filmeIf.id}">
				<p>${assistido.id}</p>
				<h2>${filmeIf.titulo}</h2>
				<p>${filmeIf.id }</p>
				<p>Diretor: ${filmeIf.diretor}</p>
				<p>Ano de Lançamento: ${filmeIf.ano_lancamento}</p>
				<p>Genero: ${filmeIf.genero}</p>
				<p>Nacionalidade: ${filmeIf.nacionalidade}</p>
				<p>Avaliação: ${assistido.avaliacao}</p>
				<p>Data vista: ${assistido.dataFormatada }</p>
				
				<a href="/listfilm/Control?acao=AssistidoTelaAlterar&id=${assistido.id}&id_filme=${filmeIf.id}">Alterar Avaliação</a>
				<hr>
			</c:if>
		</c:forEach>
	</c:forEach>




</body>
</html>


