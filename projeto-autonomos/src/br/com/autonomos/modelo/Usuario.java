package br.com.autonomos.modelo;

public class Usuario extends Pessoa {

	private String senha;
	private String email;

	public Usuario(String senha, int id, String nome, String email,
			String telefone, Endereco endereco) {
		super(id, nome, email, telefone, endereco);
		super.setTipoPessoa("usuario");
		this.senha = senha;

	}
	
	public Usuario() {
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public boolean validaSenha(String senha){
		if(senha.equals(getSenha())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return email + " , " + senha + " , " + super.getTipoPessoa();
	}

}
