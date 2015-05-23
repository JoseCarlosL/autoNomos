package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionValidaLoginUsuario {

	public Connection conectcaoBDMySql() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/autonomos?user=root&password=root");

		} catch (Exception e) {
		}

		return con;
	}

	public String email = "";
	public String senha = "";
	public boolean result = false;

	public boolean verificarUsuario(String email, String senha) {
		String sql = "";
		Connection con = conectcaoBDMySql();
		sql += "select email, senha from usuarios";
		sql += "where email = " + "'" + email + "'";
		sql += "and senha = " + "'" + senha + "'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				result = true;
				email = rs.getString("email");
				senha = rs.getString("senha");
				
			}
		}

		catch (Exception e) {
		}

		return result;

	}
}
