package classesWeb;

public class Clientes extends Pessoa {
	
	//lista de usuarios
	Usuario usuario;

	public Clientes(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco, String usuarios) {
		super(id, nome, email, telefone, cpf, endereco);

	}
	
	protected void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	protected Usuario getUsuario(){
		return usuario;
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
