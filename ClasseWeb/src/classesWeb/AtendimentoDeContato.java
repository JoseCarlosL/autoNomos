<<<<<<< HEAD:ClasseWeb/src/classesWeb/AtendimentoDeContato.java
package classesWeb;

import java.util.Date;

public class AtendimentoDeContato {
	
	private int id;
	private int id_visitante;
	private Date data;
	private String email;
	private int telefone;
	private boolean atendido;
	private String duvida;
	
	public Atendimento(int id, Date data, String email, int telefone, boolean atendido, String id_visitante
			String duvida) {
		
		this.id = id;
		this.data = data;
		this.email = email;
		this.telefone = telefone;
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
=======
package classesWeb;

import java.util.Date;

public class Atendimento {

	private int id;
	private String data;
	private int id_visitante;
	private boolean atendido;
	private String duvida;

	public Atendimento(int id, String data, int id_visitante, boolean atendido,
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

	protected String getData() {
		return data;
	}

	protected void setData(String data) {
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

	protected void setDuvida(String duvida) {
		this.duvida = duvida;
	}

}
>>>>>>> 60eb89094482b5bf08836510210c571497451606:ClasseWeb/src/classesWeb/Atendimento.java
