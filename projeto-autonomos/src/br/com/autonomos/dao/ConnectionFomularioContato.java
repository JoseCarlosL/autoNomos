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
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/autonomos?user=root&password=carlos");
			String sql = "INSERT INTO form_contato (nome, email, telefone, data, descricao_duvida) values (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setString(3, telefone);
			ps.setString(4, data);
			ps.setString(5, duvida);

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
