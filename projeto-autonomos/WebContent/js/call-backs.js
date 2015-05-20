/**
 * 
 */

function validaCamposEmBranco(contato) {
	//var formulario = document.getElementById('form_contato');
	
	if (contato.nome.value==" "){
		alert("Preencha o campo nome corretamente!");
		contato.nome.focus();
		return false;
	}
	
	
}
