<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Gerar Relatório</title>
		<meta charset="UTF-8" />
		<link href="css/opcaoRelatorio.css" type="text/css" rel="stylesheet" />
		<script src="js/.js" type="text/javascript"></script>
	</head>
<body>
<form action = "relatorioEnergia.jsp" method="post">
			<div id="luzes">
				<fieldset>
					<legend>Gerar relatório de controle de luz</legend>
				<table>
					<tr>
						<td>Luz <input type="checkbox" name="luz" value="luz" /></td>
					</tr>
					<tr>
						<td>do dia <input type="date" name="dataInicio" size="44" /></td>
					</tr>
					<tr>
						<td>ao dia <input type="date" name="dataFinal" size="44" /></td>
					</tr>
					<tr>
						<td><input id="gerarLuz" type="submit" value="Gerar"/> <input type="reset" value="Limpar" /></td>
					</tr>
				</table>
				
				</fieldset>
			
			</div>
			<div id="agua">
				
				<fieldset>
					<legend>Gerar relatório de controle de água</legend>
				<table>
					<tr>
						<td>Água <input type="checkbox" name="agua" value="água" /></td>
					</tr>
					<tr>
						<td>do dia <input type="date" name="data" size="44" /></td>
					</tr>
					<tr>
						<td>ao dia <input type="date" name="data" size="44" /></td>
					</tr>
					<tr>
						<td><input id="gerarAgua" type="submit" value="Gerar" /> <input type="reset" value="Limpar" /></td>
					</tr>
				</table>
				</fieldset>
			</div>
		</form>
</body>
</html>