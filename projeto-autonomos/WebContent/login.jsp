<%@page import="br.com.autonomos.dao.ConnectionValidaLoginUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login com JSP</title>
</head>
<body>
	<%
		ConnectionValidaLoginUsuario user = new ConnectionValidaLoginUsuario();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		boolean status = user.verificarUsuario(senha, email);

		if (user.result == true) {
			String url = "http://localhost:8080/ClasseWeb/platClient.html";
			response.sendRedirect(url);

		} else {
			out.println("Não entrou");
		}
	%>



</body>
</html>