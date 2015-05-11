package java;

import java.util.Date;

public class RelatoDeAtendimento {

	private int id;
	private String nome;

	private String email;
	private String telefone;
	private String data;
	private int id_visitante;
	private boolean atendido;
	private String duvida;

	public RelatoDeAtendimento(int id, String nome, String email,
			String telefone, String data, int id_visitante, boolean atendido,
			String duvida) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.data = data;
		this.id_visitante = id_visitante;
		this.atendido = atendido;
		this.duvida = duvida;
	}
	
	public RelatoDeAtendimento(){
		
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	protected String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	protected int getId_visitante() {
		return id_visitante;
	}

	protected void setId_visitante(int id_visitante) {
		this.id_visitante = id_visitante;
	}

	protected boolean getAtendido() {
		return atendido;
	}

	protected void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	protected String getDuvida() {
		return duvida;
	}

	public void setDuvida(String duvida) {
		this.duvida = duvida;
	}

}
