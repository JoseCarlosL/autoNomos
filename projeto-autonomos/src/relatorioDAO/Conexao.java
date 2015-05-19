package relatorioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import relatorioDeConsumo.DataFinalRelatorio;
import relatorioDeConsumo.DataInicioRelatorio;

public class Conexao {
	
	public List<DataInicioRelatorio> procurarInicio(Connection con, DataInicioRelatorio dataInicio) throws SQLException{
		List<DataInicioRelatorio> lista = new ArrayList<DataInicioRelatorio>();
			
		String sql = "select data from relatorio where data = (?)";
			try {
				
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setDate(1, dataInicio.getDataInicio());
				ResultSet rs = stm.executeQuery();
				while(rs.next()){
					lista.add(new DataInicioRelatorio(rs.getDate(1)));
				}
			}
		
		return lista;
	}
	
	public List<DataFinalRelatorio> procurarFinal(Connection con) throws SQLException{
		List<DataFinalRelatorio> lista = new ArrayList<DataFinalRelatorio>();
			
		String sql = "select data from relatorio";
			try(PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()){
				while(rs.next()){
					lista.add(new DataFinalRelatorio(rs.getDate(1)));
				}
			}
		
		return lista;
	}
	
}
