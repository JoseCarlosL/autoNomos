package br.com.autonomos.relatorioConsumo;

import java.sql.Date;

public class ValoresDeBusca {
	
	private Date dataInicial;
	private Date dataFinal;
	private double kilowatt;
	private double valor;
	
	public ValoresDeBusca() {

	}
	
	public ValoresDeBusca(Date dataInicio, Date dataFim, double kw, double valor){
		this.dataInicial = dataInicio;
		this.dataFinal = dataFim;
		this.kilowatt = kw;
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

	public double getKilowatt() {
		return kilowatt;
	}

	public void setKilowatt(double kilowatt) {
		this.kilowatt = kilowatt;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return kilowatt + " " + valor;
	}
	
}
