package br.com.autonomos.modelo;


public class Visitante extends Pessoa {
	
	public Visitante(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco) {
		super(id, nome, email, telefone, endereco);
		

	}
	
	public Visitante() {
		super.setTipoPessoa("visitante");
	}

	public void solicitarAtendimento(int id_Visitante) {
		// RelatoDeAtendimento relato = new RelatoDeAtendimento();
	}

}
