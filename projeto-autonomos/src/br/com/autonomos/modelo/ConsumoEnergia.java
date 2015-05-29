package br.com.autonomos.modelo;

import java.sql.Date;

public class ConsumoEnergia {
	
	private Date dataInicial;
	private Date dataFinal;
	private double kilowatt;
	private double valor;
	
	public ConsumoEnergia() {

	}
	
	public ConsumoEnergia(Date dataInicio, Date dataFim, double kw, double valor){
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
