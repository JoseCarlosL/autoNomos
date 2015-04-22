package classesWeb;

import java.util.Date;

public class Erro {
	private int id;
	private String horario;
	private Date data;
	private String descricao;
	private int id_cliente;

	public Erro(int id, String horario, Date data, String descricao,
			int id_cliente) {
		this.id = id;
		this.horario = horario;
		this.data = data;
		this.descricao = descricao;
		this.id_cliente = id_cliente;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getHorario() {
		return horario;
	}

	protected void setHorario(String horario) {
		this.horario = horario;
	}

	protected Date getData() {
		return data;
	}

	protected void setData(Date data) {
		this.data = data;
	}

	protected String getDescricao() {
		return descricao;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	protected int getId_cliente() {
		return id_cliente;
	}

	protected void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
