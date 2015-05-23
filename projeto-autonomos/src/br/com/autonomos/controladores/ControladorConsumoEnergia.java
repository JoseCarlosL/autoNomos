package br.com.autonomos.controladores;

import java.sql.SQLException;
import java.util.List;

import br.com.autonomos.dao.ConnectionBuscaValorConsumoEnergia;
import br.com.autonomos.relatorioConsumo.ConsumoEnergia;

public class ControladorConsumoEnergia {
	
	private static ControladorConsumoEnergia instance;
	private ConnectionBuscaValorConsumoEnergia energiaDAO;
	
	private ControladorConsumoEnergia(){
		super();
		this.energiaDAO = new ConnectionBuscaValorConsumoEnergia();
	}//Controlador
	
	public static ControladorConsumoEnergia getInstance(){
		if(instance == null){
			instance = new ControladorConsumoEnergia();
		}
		return instance;
	}//getInstance
	
	public List<ConsumoEnergia> buscar(String dateInicio, String dateFinal) throws SQLException{
		return energiaDAO.buscador(dateInicio, dateFinal);
	}
}
