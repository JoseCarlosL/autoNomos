package relatorioDeConsumo;

import java.util.Date;

public class DataFinalRelatorio {
	private Date dataFinal;
	
	public DataFinalRelatorio(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicio() {
		return dataFinal;
	}

	public void setDataInicio(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	@Override
	public String toString() {
		return dataFinal+ " ,";
	}
}
