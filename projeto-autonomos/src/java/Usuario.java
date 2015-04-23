package java;

public class Usuario extends Pessoa {

	private String senha;

	public Usuario(String senha, int id, String nome, String email,
			String telefone, Endereco endereco) {
		super(id, nome, email, telefone, endereco);
		this.senha = senha;

	}

	private String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	
	public boolean validaSenha(String senha){
		if(senha.equals(getSenha())){
			return true;
		}else{
			return false;
		}
	}

}
