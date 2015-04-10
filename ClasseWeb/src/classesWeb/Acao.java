package classesWeb;

public class Acao {
	private int id_cliente;
	private String descricao;
	private String horario;
	
	public Acao(int id_cliente, String descricao, String horario){
		this.id_cliente = id_cliente;
		this.descricao = descricao;
		this.horario = horario;
	}
	
	protected int getId_cliente(){
		return id_cliente;
	}
	
	protected void setId_cliente(int id_cliente){
		this.id_cliente = id_cliente;
	}
	
	protected String getDescricao(){
		return descricao;
	}
	
	protected void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	protected String getHorario(){
		return horario;
	}
	
	protected void setHorario(String horario){
		this.horario = horario;
	}
}
