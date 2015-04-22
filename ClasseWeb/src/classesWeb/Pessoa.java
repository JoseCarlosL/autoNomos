package classesWeb;

public class Pessoa {

	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Endereco endereco;

	public Pessoa(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getTelefone() {
		return telefone;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	protected String getCpf() {
		return cpf;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}

	protected Endereco getEndereco() {
		return endereco;
	}

	protected void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
