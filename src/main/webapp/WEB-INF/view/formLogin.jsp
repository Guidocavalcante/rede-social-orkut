<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	Login: <br /><br />
	

 E-mail: <input type="text" name="email"/>
	<br /><br />
   Senha: <input type="password" name="senha"/>
	<br /><br />
	<input type="hidden" name="acao" value="LoginUsuario">
	<input type="submit" />
	
	
	</form>
</body>
</html>