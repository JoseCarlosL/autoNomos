package relatorioDeConsumo;

import java.util.Date;

public class DataFinalRelatorio {
	
	private Date dataFinal;
	private double kilowatt;
	private double valor;
	
	public DataFinalRelatorio() {

	}
	
	public DataFinalRelatorio(Date datafinal, double kw, double valor){
		this.dataFinal = datafinal;
		this.kilowatt = kw;
		this.valor = valor;
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
		return dataFinal+ " ," + kilowatt + " , " + valor +"\n";
	}
}
