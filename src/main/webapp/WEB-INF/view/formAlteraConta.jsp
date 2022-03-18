<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkAlteraConta"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action= "${linkEntradaServlet}" method ="post">
	
	Orkut <br /><br />
	
	Cadastre sua conta: <br /><br />
	
	Nome: <input type="text" name="nome" value="${conta.nome}"/>
	<br /><br />
	Data de Nascimento: <input type="text" name="data" value="<fmt:formatDate value="${conta.dataNascimento}" pattern="dd/MM/yyyy"/>"/>
	<br /><br />
 E-mail: <input type="text" name="email" value="${conta.email}"/>
	<br /><br />
   Senha: <input type="password" name="senha" value="${conta.senha}"/>
	<br /><br />
	<input type="hidden" name="id" value="${conta.id}"/>
	<input type="hidden" name="acao" value="AlteraConta">
	<input type="submit" />
	
	
	</form>
</body>
</html>