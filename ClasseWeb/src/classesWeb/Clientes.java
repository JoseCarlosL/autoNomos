package classesWeb;

public class Clientes extends Pessoa {

	// lista de usuarios
	Usuario usuario;
	String cpf;

	public Clientes(int id, String nome, String email, String telefone,
			Endereco endereco, String usuarios, String cpf) {
		super(id, nome, email, telefone, endereco);
		this.cpf = cpf;
		}

	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	protected Usuario getUsuario() {
		return usuario;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}

	protected String getCpf() {
		return cpf;
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
