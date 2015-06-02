package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.autonomos.modelo.RelatorioConsumoAgua;
import br.com.autonomos.modelo.RelatorioConsumoEnergia;

public class ConnectionBuscaValorConsumo {

	private final String BUSCA_VALORES = "select sum(kilowatt), sum(valor) from consumo where data between (?) and (?)";
	private final String PROCURA_CONSUMO_AGUA = "select sum(litros), sum(valor) from consumoAgua where data between (?) and (?)";
	
	public List<RelatorioConsumoEnergia> listValorBusca = new ArrayList<RelatorioConsumoEnergia>();
	
		//String url = "jdbc:mysql://localhost/autonomos?user=root&password=carlos";


	public List<RelatorioConsumoEnergia> procurarValorEnergia (String dateInicio, String dateFinal) throws SQLException{
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=root";
		String sql = BUSCA_VALORES;
		
		RelatorioConsumoEnergia valorBusca = new RelatorioConsumoEnergia();
		Connection conn = null;
		try {
			listValorBusca.clear();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(url);
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, dateInicio);
			stm.setString(2, dateFinal);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				valorBusca.setKilowatt(rs.getDouble(1));
				valorBusca.setValor(rs.getDouble(2));
				listValorBusca.add(valorBusca);
			}
		} finally {
			conn.close();
		}
		
		return listValorBusca;
	}
	
	public List<RelatorioConsumoAgua> listConsumoAgua = new ArrayList<RelatorioConsumoAgua>();

	public List<RelatorioConsumoAgua> procurarValorAgua (String dataInicio, String dataFinal) throws SQLException{
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=root";
		String sql = PROCURA_CONSUMO_AGUA;
		RelatorioConsumoAgua consumoAgua = new RelatorioConsumoAgua();
		Connection conn = null;
			try{
				listConsumoAgua.clear();
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(url);
				PreparedStatement stm = conn.prepareStatement(sql);
				stm.setString(1, dataInicio);
				stm.setString(2, dataFinal);
				ResultSet rs = stm.executeQuery();
				while(rs.next()){
					consumoAgua.setLitros(rs.getDouble(1));
					consumoAgua.setValor(rs.getDouble(2));
					listConsumoAgua.add(consumoAgua);
				}
			}finally{
				conn.close();
			}
			
			return listConsumoAgua;
	}
}
