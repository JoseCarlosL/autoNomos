/**
 * 
 */

function logout() {
	var confirmacao = confirm("Voc� deseja realmente sair?");
	if (confirmacao == true) {
		window.location.href = "http://localhost:8080/ClasseWeb/login.html";
	}

}