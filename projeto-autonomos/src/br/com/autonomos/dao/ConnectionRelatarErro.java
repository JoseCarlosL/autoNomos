package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionRelatarErro {

	public Connection coneccaoBDMysqlRelatoErro(String categoria,
			String descricao) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/autonomos?user=root&password=root");
			String sql = "INSERT INTO relato_erro (categoria, descricao) values (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, categoria);
			ps.setString(2, descricao);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ps.close();
			con.close();
		}
		return con;

	}

}
