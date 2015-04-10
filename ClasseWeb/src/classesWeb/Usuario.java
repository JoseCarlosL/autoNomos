package classesWeb;

public class Usuario {

	private String senha;
	private Pessoa pessoa;

	public Usuario(String senha, Pessoa pessoa) {
		super();
		this.senha = senha;
		this.pessoa = pessoa;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	protected Pessoa getPessoa() {
		return pessoa;
	}

	protected void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	protected void logar() {

	}

}
