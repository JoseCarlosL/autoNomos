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
		String nome_c = request.getParameter("nome");
		String email_c = request.getParameter("email");
		String telefone_c = request.getParameter("telefone");
		String data_c = request.getParameter("data");
		String descricao_c = request.getParameter("duvida");
		
		if(nome_c.equals(null)){
			out.println("preencha os campos");
		}else{
			out.println("okay, passou");
		}
	
	%>
	


</body>
</html>