package br.com.autonomos.modelo;


public class Visitante extends Pessoa {
	
	private String email;
	private String senha;
	
	public Visitante(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco) {
		super(id, nome, email, telefone, endereco);
		

	}
	
	public Visitante() {
		super.setTipoPessoa("visitante");
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void solicitarAtendimento(int id_Visitante) {
		// RelatoDeAtendimento relato = new RelatoDeAtendimento();
	}

}
