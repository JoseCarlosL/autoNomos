package br.com.autonomos.controladores;

import java.sql.SQLException;
import java.util.List;

import br.com.autonomos.dao.ConnectionBuscaValorConsumo;
import br.com.autonomos.modelo.ConsumoAgua;

public class ControladorConsumoAgua {
	
	private static ControladorConsumoAgua instace;
	private ConnectionBuscaValorConsumo aguaDAO;
	
	private ControladorConsumoAgua(){
		super();
		this.aguaDAO = new ConnectionBuscaValorConsumo();
	}
	
	//------Consumo de agua----
	
	public static ControladorConsumoAgua getInstance(){
		if(instace == null){
			instace = new ControladorConsumoAgua();
		}
		return instace;
	}
	
	public List<ConsumoAgua> procurarConsumo(String dataInicio, String dataFinal) throws SQLException{
		return aguaDAO.procurarValorAgua(dataInicio, dataFinal);
	}
}
