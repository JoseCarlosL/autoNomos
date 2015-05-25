package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import br.com.autonomos.modelo.Usuario;

public class ConnectionValidaLoginUsuario {

	List<Usuario> listUser = new ArrayList<Usuario>();
	public boolean status = false;
	
	public List<Usuario> verificarUsuario(String email, String senha) throws SQLException{
		String sql = "select email, senha from usuarios where email = (?) and senha = (?)";
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=carlos";
		Usuario user = new Usuario();
		Connection conn = null;
			try{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(url);
				PreparedStatement stm = conn.prepareStatement(sql);
				stm.setString(1, email);
				stm.setString(2, senha);
				ResultSet rs = stm.executeQuery();
				while(rs.next()){
					user.setEmail(rs.getString(1));
					user.setSenha(rs.getString(2));
					listUser.add(user);
				}
			}finally{
				conn.close();
			}
			return listUser;
	}
}
