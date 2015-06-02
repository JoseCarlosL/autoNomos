<%@page import="br.com.autonomos.modelo.Pessoa"%>
<%@page import="br.com.autonomos.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.autonomos.dao.ConnectionValidaLoginUsuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="utf-8">
<title>Login com JSP</title>
</head>
<body>
	<%
		ConnectionValidaLoginUsuario user = new ConnectionValidaLoginUsuario();
			List<Usuario> usuario;
			Pessoa p = new Pessoa();
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			usuario = user.verificarUsuario(email, senha);

			for (Usuario u : usuario) {
		if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
			String url = "http://localhost:8080/ClasseWeb/plataformaUsuario.jsp";
			p.setTipoPessoa("visitante");
			response.sendRedirect(url);
		} 
			
	
			}
	%> 



</body>
</html>