package relatorioDeConsumo;

import java.util.Date;


public class ConsumoDeEnergia {
	
	private Date dataInicio;
	private Date dataTermino;
	
	public ConsumoDeEnergia(Date inicio) {
		this.dataInicio = inicio;
		//this.dataTermino = termino;
	}
	
	@Override
	public String toString() {
		return dataInicio + " até " + dataInicio;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
}
