package relatorioDeConsumo;

import java.util.Date;


public class DataInicioRelatorio {
	
	private Date dataInicio;
	
	public DataInicioRelatorio() {

	}
	
	public DataInicioRelatorio(Date DataInicio) {
		this.dataInicio = DataInicio;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	@Override
	public String toString() {
		return dataInicio + " ,";
	}
}
