
function validarCampos() {
	if (document.getElementById("selecione").value != "") {

		if (document.getElementById("descricao").value != "") {
			location.href = "http://localhost:8080/ClasseWeb/plataformaUsuario.jsp";
			alert("Enviado com sucesso. Entraremos em contato em breve!");
		}
	}
}
