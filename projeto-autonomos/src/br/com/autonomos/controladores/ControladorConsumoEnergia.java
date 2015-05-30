package br.com.autonomos.controladores;

import java.sql.SQLException;
import java.util.List;

import br.com.autonomos.dao.ConnectionBuscaValorConsumo;
import br.com.autonomos.modelo.RelatorioConsumoEnergia;

public class ControladorConsumoEnergia {
	
	private static ControladorConsumoEnergia instance;
	private ConnectionBuscaValorConsumo energiaDAO;
	
	private ControladorConsumoEnergia(){
		super();
		this.energiaDAO = new ConnectionBuscaValorConsumo();
	}//Controlador
	
	public static ControladorConsumoEnergia getInstance(){
		if(instance == null){
			instance = new ControladorConsumoEnergia();
		}
		return instance;
	}//getInstance
	
	public List<RelatorioConsumoEnergia> buscar(String dateInicio, String dateFinal) throws SQLException{
		return energiaDAO.procurarValorEnergia(dateInicio, dateFinal);
	}
}
