/**
 * 
 */

function validarCampos() {
	if (document.getElementById("nome").value != "") {

		if (document.getElementById("email").value != "") {

			if (document.getElementById("telefone").value != "") {

				if (document.getElementById("data").value != "") {

					if (document.getElementById("duvida").value != "") {
						alert("Enviado com sucesso. Entraremos em contato em breve!");
					}
				}
			}
		}
	}
}
