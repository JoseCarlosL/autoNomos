<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acesso Cliente</title>
<meta charset="UTF-8" />
<link href="css/platClient.css" type="text/css" rel="stylesheet" />
<script src="js/platClient.js" type="text/javascript"></script>
<script src="js/jquery.min.js"></script>
<script src="js/skel.blz.js"></script>
<script src="js/init.js"></script>

<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-xlarge.css" />
</noscript>
</head>

<body>
	<%
		String nome = "Carlos";
	%>
	<!-- Header -->
	<header id="header" class="skel-layers-fixed">
	<h1>
		<a href="platClient.html">AutoNomos</a>
	</h1>
	<nav id="nav">
	<ul>
		<li><a href="autoNomos AJUDA.pdf" target="mainframe">Ajuda</a></li>
		<li><a href="relatarErro.html" target="mainframe">Relatar
				Erro</a></li>
		<li><a href="login.html" class="button special">SAIR</a></li>

	</ul>
	</nav> </header>

	<div id="container">

		<div id='cssmenu'>
			<ul>
				<li><a href='iluminacao.html' target="mainframe"><span>Controle
							de iluminação</span></a></li>
				<li class='active has-sub'><a href='relatorioAgua.html'
					target="mainframe"><span>Consumo de água</span></a>
				<li class='last'><a href='opcaoRelatorio.html'
					target="mainframe"><span>Relatório</span></a></li>
			</ul>
		</div>

		<div id="content">
			<iframe id="mainframe" name="mainframe" src="iluminacao.html"
				allowtransparency="true"></iframe>
		</div>

	</div>
</body>
</html>