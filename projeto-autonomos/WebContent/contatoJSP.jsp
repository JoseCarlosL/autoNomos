
<%@page import="br.com.autonomos.dao.ConnectionFomularioContato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String nome_f = request.getParameter("nome");
		String email_f = request.getParameter("email");
		String telefone_f = request.getParameter("telefone");
		String data_f = request.getParameter("data");
		String duvida_f = request.getParameter("duvida");

		out.println("Dúvida enviada!");

		ConnectionFomularioContato form = new ConnectionFomularioContato();
		form.coneccaoBDMysqlFormContato(nome_f, email_f, telefone_f,
				data_f, duvida_f);
	%>

</body>
</html>