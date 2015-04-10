package classesWeb;

public class Visitante extends Pessoa {

	private Pessoa pessoa;

	public Visitante(String rua, String numero, String complemento,
			String bairro, String cidade, String estado, String cep, int id,
			String nome, String email, String telefone, String cpf,
			Endereco endereco, Pessoa pessoa) {

		super(rua, numero, complemento, bairro, cidade, estado, cep, id, nome,
				email, telefone, cpf, endereco);
		this.pessoa = pessoa;
	}

	protected Pessoa getPessoa() {
		return pessoa;
	}

	protected void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
