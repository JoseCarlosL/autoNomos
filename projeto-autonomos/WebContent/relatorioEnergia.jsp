<%@page import="br.com.autonomos.relatorioConsumo.ValoresDeBusca"%>
<%@page import="relatorioDeConsumo.DataInicioRelatorio"%>
<%@page import="br.com.autonomos.controlador.ManipuladorBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="relatorioDeConsumo.DataFinalRelatorio"%>
<%@page import="java.util.List"%>
<%@page import="br.com.autonomos.controlador.ManipuladorBD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Relatório de consumo de energia</title>
<link rel="stylesheet" type="text/css" href="css/resetRelatorio.css">
<link rel="stylesheet" type="text/css" href="css/tabelaRelatorio.css">
</head>
<body>
	<header>
	<form action="relatorio" method="post">
		<div class="container">
			<h1>autoNomos - ecoHome</h1>
		</div>
	</header>
	<main class="container"> <section>
	<h2>Consumo de energia</h2>
	<table>
		<tr>
			<th>Período</th>
			<th>Gastos (Kw)</th>
			<th>Valor em R$</th>
		</tr>
		<%
		ManipuladorBD manipulador = new ManipuladorBD();
		ValoresDeBusca valorBusca = new ValoresDeBusca();
		
		String dataInicio = "2015-05-01"; 
		String dataFinal = "2015-05-10";
		%>
		<%
			//finalDate = manipulador.procurarDataFinal("2015-05-01");
			//inicialDate = manipulador.procurarDataInicial("2015-05-10");
			
			
			manipulador.buscador(dataInicio, dataFinal);
			
			for(ValoresDeBusca f: manipulador.listValorBusca){
			
		
		%>
		<tr class="paciente">
			<td class="info-peso" id="peso-1"><%= dataInicio %><p> até </p><%= dataFinal %></td>
			<td class="info-altura" id="altura-1"><%=f.getKilowatt()%></td>
			<td class="info-imc" id="imc-1"><%=f.getValor()%></td>
		</tr>
		
		<% 
		} 
		%>
			
		<tr class="paciente">
			<td class="info-peso" id="peso-2">10/02/2015 a 10/03/2015</td>
			<td class="info-altura" id="altura-2">80000</td>
			<td class="info-imc" id="imc-2">978,32</td>
		</tr>
	</table>

	<button id="calcula-imcs" class="botao ">Imprimir Relatório</button>

	</section>
	</form>
</body>
</html>