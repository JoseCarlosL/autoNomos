package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnergiaCrud {
	
	public void Criar(Connection con, Energia energia) throws SQLException{
		
		String sql = "insert into ecohome values (?, ?)";
		try(PreparedStatement stm = con.prepareStatement(sql)){
		stm.setDouble(1, energia.energia);
		stm.setDouble(2, energia.valor);
		
		stm.executeUpdate();
		
		}
	}//Criar
	
	public List<Energia> Ler(Connection con) throws SQLException{
		List<Energia> lista = new ArrayList<>();
		
		String sql = "select energia, valor from ecohome";
		try(PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery()){
				while(rs.next()){
					lista.add(new Energia(rs.getDouble(2), rs.getDouble(1)));
				}
		}
		
		return lista;
	}//Ler
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		try(Connection con = DriverManager.getConnection(url)){
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			EnergiaCrud crud = new EnergiaCrud();
			Energia en1 = new Energia(222, 11.11);
			Energia en2 = new Energia(34.222, 456.4);
			
			List<Energia> contas = crud.Ler(con);
			for(Energia ener: contas){
				System.out.println(ener);
			}
		}
		
	}
}
