package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import relatorioDAO.Conexao;
import relatorioDeConsumo.DataFinalRelatorio;
import relatorioDeConsumo.DataInicioRelatorio;

public class ControladorRelatorio {
	
	private Conexao conexao;
	
	public List<DataInicioRelatorio> procurarDataInicio(Connection con) throws SQLException{
		return conexao.procurarInicio(con);
	}
	
	public List<DataFinalRelatorio> procurarDataFinal(Connection con) throws SQLException{
		return conexao.procurarFinal(con);
	}
}
