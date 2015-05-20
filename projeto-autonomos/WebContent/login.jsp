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
		// usuario e senha corretos
		String usuario_p = "haysa";
		String senha_p = "haysa";

		String usuario = request.getParameter("email");
		String senha = request.getParameter("senha");

		// verifica se os dados informados estão corretos
		if ((usuario.equals(usuario_p)) && (senha.equals(senha_p))) {
			String redirectURL = "/ClasseWeb/platClient.html";
			response.sendRedirect(redirectURL);

		} else {
			%>
			<script language="JavaScript" type="text/javascript">
				alert("lal");
			</script>
		
			<%
			String redirect = "/ClasseWeb/login.html";
			response.sendRedirect(redirect);

		}
	%>


</body>
</html>