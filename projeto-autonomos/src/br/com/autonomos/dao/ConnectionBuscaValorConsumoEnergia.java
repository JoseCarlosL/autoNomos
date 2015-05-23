package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.autonomos.relatorioConsumo.ConsumoEnergia;

public class ConnectionBuscaValorConsumoEnergia {

	private final String BUSCA_VALORES = "select sum(kilowatt), sum(valor) from consumo where data between (?) and (?)";

	
	public List<ConsumoEnergia> listValorBusca = new ArrayList<ConsumoEnergia>();
	
	public List<ConsumoEnergia> buscador (String dateInicio, String dateFinal) throws SQLException{
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		String sql = BUSCA_VALORES;
		
		ConsumoEnergia valorBusca = new ConsumoEnergia();
		Connection conn = null;
		try {
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
}
