package classesWeb;

import java.util.Date;

public class Atendimento {
	
	private int id;
	private Date data;
	private int id_visitante;
	private boolean atendido;
	private String duvida;
	
	public Atendimento(int id, Date data, int id_visitante, boolean atendido,
			String duvida) {
				this.id = id;
		this.data = data;
		this.id_visitante = id_visitante;
		this.atendido = atendido;
		this.duvida = duvida;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected Date getData() {
		return data;
	}

	protected void setData(Date data) {
		this.data = data;
	}

	protected int getId_visitante() {
		return id_visitante;
	}

	protected void setId_visitante(int id_visitante) {
		this.id_visitante = id_visitante;
	}

	protected boolean isAtendido() {
		return atendido;
	}

	protected void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	protected String getDuvida() {
		return duvida;
	}

	protected void setDuvida(String duvida) {
		this.duvida = duvida;
	}

}
