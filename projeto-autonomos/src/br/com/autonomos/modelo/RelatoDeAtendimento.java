package br.com.autonomos.modelo;

import java.util.Date;

public class RelatoDeAtendimento {

	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String data;

	// private boolean atendido;
	private String duvida;

	public RelatoDeAtendimento(String nome, String email,
			String telefone, String data, String duvida) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.data = data;
		// this.atendido = atendido;
		this.duvida = duvida;
	}

	public RelatoDeAtendimento() {

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDuvida() {
		return duvida;
	}

	public void setDuvida(String duvida) {
		this.duvida = duvida;
	}

}
