<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List,br.com.guido.orkut.modelo.Conta" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/orkut/entrada?acao=Logout">Logout</a>
<br /><br />

	Acessando a conta: ${contaLogada.nome}
	<br /><br />
		Lista de Contas Cadastradas
		<br /><br />
		
		<c:forEach items="${contas}" var="conta">
		<li>Nome: ${conta.nome} - 
			E-mail: ${conta.email}
			<a href="/orkut/entrada?acao=RemoveConta&id=${conta.id}">Excluir conta</a>
			<a href="/orkut/entrada?acao=MostraConta&id=${conta.id}">Editar conta</a>
			<br />
			Senha: ${conta.senha} - 
			Data de Nascimento: <fmt:formatDate value="${conta.dataNascimento}" pattern="dd/MM/yyyy"/> <br />
			<br /> </li>
		</c:forEach>
		<br /><br />
		<a href="/orkut/entrada?acao=CadastraConta">Cadastrar nova conta</a>
		
		
		
</body>
</html>