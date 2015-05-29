<%@page import="br.com.autonomos.dao.ConnectionBuscaValorConsumo"%>
<%@page import="br.com.autonomos.controladores.ControladorConsumoEnergia"%>
<%@page import="br.com.autonomos.modelo.ConsumoEnergia"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date" %>>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Relatório de consumo de energia</title>
<link rel="stylesheet" t'ype="text/css" href="css/resetRelatorio.css">
<link rel="stylesheet" type="text/css" href="css/tabelaRelatorio.css">
</head>
<body>
	<header>
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
		ConsumoEnergia valorBusca = new ConsumoEnergia();
		ControladorConsumoEnergia controler = ControladorConsumoEnergia.getInstance();
		List<ConsumoEnergia> energia;
		String dataInicio = request.getParameter("dataInicio");
		String dataFinal = request.getParameter("dataFinal");
		%>
		<%
			
			energia = controler.buscar(dataInicio, dataFinal);
			
			/*SimpleDateFormat formate =  new SimpleDateFormat("dd-MM-yyyy");
			Date dataInic = new Date(formate.parse(dataInicio).getTime());
			
			String dataFormatada = "dd-MM-yyyy";
			SimpleDateFormat formato = new SimpleDateFormat(dataFormatada);
			String dataIf = formate.format(dataInic);
			* TENHO QUE CONCERTAR ESSA PARTE PARA O FORMATO DA DATA */
			
			for(ConsumoEnergia b: energia){
				
			/*
			* 
			*/
		
		%>
		<tr class="paciente">
			<td class="info-peso" id="peso-1"><%= dataInicio %> até <%= dataFinal %></td>
			<td class="info-altura" id="altura-1"><%=b.getKilowatt()%></td>
			<td class="info-imc" id="imc-1"><%=b.getValor()%></td>
		</tr>
		
		<% 
		}//for
		%>
	</table>

	<button id="calcula-imcs" class="botao ">Imprimir Relatório</button>

	</section>
</body>
</html>