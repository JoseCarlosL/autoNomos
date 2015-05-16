<%@ pageimport="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding = "ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<p>TExto</p>
		<% for (int i=0; i<5; i++) { %>
		<p>Linha: <%=i%></p>
		<%}%>
		<p><%= new Date() %></p>
		
		<% Date hoje = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		%>
		hoje é: <%= formato.format(hoje) %>
</html>
</body>
</html>