<%@page import="br.com.autonomos.controladores.ControladorConsumoAgua"%>
<%@page import="java.util.List"%>
<%@page import="br.com.autonomos.dao.ConnectionBuscaValorConsumo"%>
<%@page import="br.com.autonomos.relatorioConsumo.ConsumoAgua"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Relatório de consumo de água</title>
<link rel="stylesheet" type="text/css" href="css/resetRelatorio.css">
<link rel="stylesheet" type="text/css" href="css/tabelaRelatorio.css">
</head>
<body>
	<header>
	<div class="container">
		<h1>autoNomos - ecoHome</h1>
	</div>
	</header>
	<main class="container"> <section>
	<h2>Consumo de água</h2>
	<table>
		<tr>
			<th>Período</th>
			<th>Gastos (Lt)</th>
			<th>Valor em R$</th>
		</tr>
		
		<%
		ConsumoAgua consumoAgua = new ConsumoAgua();
		ControladorConsumoAgua controladorAgua = ControladorConsumoAgua.getInstance();
		List<ConsumoAgua> agua;
		String dataInicio = request.getParameter("dataInicio");
		String dataFinal = request.getParameter("dataFinal");
		%>
		<%
			agua = controladorAgua.procurarConsumo(dataInicio, dataFinal);
		
			for (ConsumoAgua a: agua){
		
		%>
		<tr class="paciente">
			<td class="info-peso" id="peso-1"><%= dataInicio %> até <%= dataFinal %></td>
			<td class="info-altura" id="altura-1"><%= a.getLitros() %></td>
			<td class="info-imc" id="imc-1"><%= a.getValor() %></td>
		</tr>
		<% 
			}//for
		%>
	</table>

	<button id="calcula-imcs" class="botao ">Imprimir Relatório</button>

	</section>
</body>
</html>