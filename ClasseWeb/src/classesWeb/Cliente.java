package classesWeb;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	// lista de usuarios
	List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	Usuario usuario;
	String cpf;

	public Cliente(int id, String nome, String email, String telefone,
			Endereco endereco, String cpf) {
		super(id, nome, email, telefone, endereco);
		this.cpf = cpf;
		listaUsuarios.add(usuario);

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

	protected void relatarErros() {
		// Erro erro = new Erro();
	}

}
