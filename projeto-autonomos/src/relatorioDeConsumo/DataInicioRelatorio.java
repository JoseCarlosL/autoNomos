package relatorioDeConsumo;

import java.util.Date;


public class DataInicioRelatorio {
	
	private Date dataInicio;
	private double kilowatt;
	private double valor;
	
	public DataInicioRelatorio() {

	}
	
	public DataInicioRelatorio(Date dataInicio, double kw, double valor){
		this.dataInicio = dataInicio;
		this.kilowatt = kw;
		this.valor = valor;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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
		return dataInicio + " , " + kilowatt + " , " + valor;
	}
}
