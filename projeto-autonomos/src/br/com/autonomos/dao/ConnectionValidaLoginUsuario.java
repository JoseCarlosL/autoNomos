package br.com.autonomos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

import org.apache.jasper.tagplugins.jstl.core.Out;

import br.com.autonomos.modelo.Usuario;
import br.com.autonomos.modelo.Visitante;

public class ConnectionValidaLoginUsuario {

	List<Usuario> listUser = new ArrayList<Usuario>();
	List<Visitante> listVis = new ArrayList<Visitante>();
	public boolean status = false;
	
	public List<Usuario> verificarUsuario(String email, String senha) throws SQLException{
		String sql = "select email, senha from usuarios where email = (?) and senha = (?)";
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=root";
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
					System.out.println(listUser.toString());
					System.out.println(user.toString());
				}
			}finally{
				conn.close();
			}
			return listUser;
	}// verificarUsuario
	
	public List<Visitante> verificarVisitante(String CampoEmail, String senha) throws SQLException{
		String sql = "select email, senha from usuarios where email = (?) and senha = (?)";
		String url = "jdbc:mysql://localhost/autonomos?user=root&password=root";
		Visitante vis = new Visitante();
		Connection conn = null;
			try{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(url);
				PreparedStatement stm = conn.prepareStatement(sql);
				stm.setString(1, CampoEmail);
				stm.setString(2, senha);
				ResultSet rs = stm.executeQuery();
				while(rs.next()){
					vis.setEmail(rs.getString(1));
					vis.setSenha(rs.getString(2));
					listVis.add(vis);
					System.out.println(listVis.toString());
					System.out.println(vis.toString());
				}
			}finally{
				conn.close();
			}
			return listVis;
	}
}
