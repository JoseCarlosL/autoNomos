function autenticacaoLogin(){

	var email = document.getElementById("email");
	var inputEmail = email.textContent;
	
	var senha = document.getElementById("senha");
	var inputSenha = senha.textContent;



	if(email == "autonomos@gmail.com" && senha == "autonomos"){
		alert("pode entrar.");
		window.location.href="platClient.html";
		return true;
	}else{
		alert("E-mail ou senha incorretos.");
	}


}