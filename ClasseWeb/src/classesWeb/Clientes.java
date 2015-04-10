package classesWeb;

public class Clientes extends Pessoa {

	private String usuarios;
	private Pessoa pessoa;

	public Clientes(String rua, String numero, String complemento,
			String bairro, String cidade, String estado, String cep, int id,
			String nome, String email, String telefone, String cpf,
			Endereco endereco, String usuarios, Pessoa pessoa) {
		super(rua, numero, complemento, bairro, cidade, estado, cep, id, nome,
				email, telefone, cpf, endereco);
		this.usuarios = usuarios;
		this.pessoa = pessoa;
	}

	protected String getUsuarios() {
		return usuarios;
	}

	protected void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}

	protected Pessoa getPessoa() {
		return pessoa;
	}

	protected void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	protected String registrarAcao() {
		String acao = null;
		return acao;
	}

	protected String relatarErros() {
		String erro = null;
		return erro;
	}

}
