package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Conexao {
	
	public static String status = "";
	static String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
	
	public static Connection getConnection(){
		Connection conn= null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url);
			java.sql.PreparedStatement stm = conn.prepareStatement("select * from ecohome");
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				status = rs.getString("valor");
			}
		}catch(SQLException e){
			status = e.getMessage();
		}catch (ClassNotFoundException e) {
			status = e.getMessage();
		}catch (Exception e) {
			status = e.getMessage();
		}
		return conn;
		
	}
	
	public static void main(String[] args) throws SQLException {
		Conexao.getConnection();
		System.out.println(Conexao.status);
	}
}
