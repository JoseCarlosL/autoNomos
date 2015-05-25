<%@page import="br.com.autonomos.dao.ConnectionRelatarErro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatar erro</title>
</head>
<body>

	<%
		
		String descricao = request.getParameter("duvida");
		String categoria = request.getParameter("erro");
		out.println("Erro enviado com sucesso.");
		
		//ConnectionRelatarErro erro = new ConnectionRelatarErro();
		//erro.coneccaoBDMysqlRelatoErro(categoria, descricao);
	
	
	
	%>

</body>
</html>