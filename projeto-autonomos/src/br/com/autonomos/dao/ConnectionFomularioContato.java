package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFomularioContato {

	public Connection coneccaoBDMysqlFormContato(String nome, String email,
			String telefone, String data, String duvida) throws SQLException {

		Connection con = null;
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=root";
		String sql = "INSERT INTO form_contato values (?, ?, ?, ?, ?)";
		
		try {

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setString(3, telefone);
			ps.setString(4, data);
			ps.setString(5, duvida);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return con;

	}

}
