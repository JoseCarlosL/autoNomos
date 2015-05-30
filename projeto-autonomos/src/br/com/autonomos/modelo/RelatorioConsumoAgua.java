package br.com.autonomos.modelo;

import java.sql.Date;

public class RelatorioConsumoAgua {
	
	private Date dataInicial;
	private Date dataFinal;
	private double litros;
	private double valor;
	
	public RelatorioConsumoAgua() {
		
	}
	
	public RelatorioConsumoAgua(Date inicio, Date fim, double lt, double valor){
		this.dataInicial = inicio;
		this.dataFinal = fim;
		this.litros = lt;
		this.valor = valor;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
