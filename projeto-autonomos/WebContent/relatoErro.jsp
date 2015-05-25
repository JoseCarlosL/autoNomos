<%@page import="br.com.autonomos.dao.ConnectionRelatarErro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relato de erro</title>
</head>
<body>

	<%
		String categoria = request.getParameter("erro");
		String descricao = request.getParameter("descricao");

		out.println("Enviado com sucesso.");
		ConnectionRelatarErro erro = new ConnectionRelatarErro();
		erro.coneccaoBDMysqlRelatoErro(categoria, descricao);
		
	%>


</body>
</html>