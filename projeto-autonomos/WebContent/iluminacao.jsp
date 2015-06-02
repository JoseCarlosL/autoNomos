<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Iluminação</title>
		<meta charset="UTF-8" />
		<link href="css/iluminacao.css" type="text/css" rel="stylesheet" />
		<script src="js/iluminacao.js" type="text/javascript"></script>
</head>
<body>
	<div id="comodos">
			<fieldset>
				<legend>SALA</legend>
				<ul>
					<div id="sala">
					<li>Luz alta <br><input class="button" type="button" value="Ligar" name="ligarLuzAlta" onclick="ligarSala1();"/> <input class="button2" type="button" value="Desligar" onclick="desligarSala1();"/>   <img id="status1" src="img/erro.png" /></li>
					<li>Luz baixa <br><input class="button" type="button" value="Ligar" onclick="ligarSala2();"/> <input class="button2" type="button" value="Desligar" onclick="desligarSala2();"/>  <img id="status2" src="img/erro.png" /></li>
					<li>Lustre <br><input class="button" type="button" value="Ligar" onclick="ligarSala3();"/> <input class="button2" type="button" value="Desligar" onclick="desligarSala3();"/>  <img id="status3" src="img/erro.png" /></li>
					</div>
					<% String luz = request.getParameter("ligarLuzAlta");%>
					<input type="text" <%= luz %>>	
				</ul>
			</fieldset>
			
			<fieldset>
				<legend>QUARTO</legend>
				<ul>
					<div id="quarto">
					<li>Luz baixa <br><input class="button" type="button" value="Ligar" onclick="ligarQuarto1();"/> <input class="button2" type="button" value="Desligar" onclick="desligarQuarto1();"/> <img id="statusq1" src="img/erro.png" /></li>
					<li>Abajour <br><input class="button" type="button" value="Ligar" onclick="ligarQuarto3();"/> <input class="button2" type="button" value="Desligar" onclick="desligarQuarto3();"/> <img id="statusq3" src="img/erro.png" /></li>
					</div>
				</ul>
			</fieldset>
			
			<fieldset >
				<legend>BANHEIRO</legend>
				<ul>
					<div id="banheiro">
					<li>Luz baixa <br><input class="button" type="button" value="Ligar" onclick="ligarBanheiro1();"/> <input class="button2" type="button" value="Desligar" onclick="desligarBanheiro1();"/> <img id="statusb1" src="img/erro.png" /></li>
					</div>
				</ul>
			</fieldset>
		</div>
</body>
</html>