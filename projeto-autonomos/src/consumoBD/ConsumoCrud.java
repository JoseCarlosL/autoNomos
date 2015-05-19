package consumoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import java.text.SimpleDateFormat;

import relatorioDeConsumo.DataInicioRelatorio;

public class ConsumoCrud {
	
	/*public void Criar(Connection con, ConsumoDeEnergia energia) throws SQLException{
		
		String sql = "insert into ecohome values (?, ?)";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setDate(1, energia.setDataInicio(dataInicio););
			stm.setDouble(2, energia.valor);
		
		stm.executeUpdate();
		
		}
	}//Criar
	*/
	
	public Connection getConnection() throws SQLException {
		Connection con = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost/testhome?user=root&password=carlos");
		return con;
	}

	public void closeConnnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<String> procurar(String datap) throws SQLException{
		List<String> lista = new ArrayList<String>();
		String sql = "select data from relatorio where data = (?)";
		Connection conne = null;
		try{	
				conne = getConnection();
				PreparedStatement stm = conne.prepareStatement(sql);
				stm.setString(1, datap);//seta a data para fazer a busca
				ResultSet rs = stm.executeQuery();
				while(rs.next()){
					
					Date valorDoBanco = rs.getDate(1);
					String dataz = "dd/MM/yyyy";
					SimpleDateFormat formatas = new SimpleDateFormat(dataz);
					String data = formatas.format(valorDoBanco);
					lista.add(data);
				}
		} finally {
			closeConnnection(conne);
		}
		
		return lista;
		
	}//Ler
	
	public static void main(String[] args) throws SQLException {
		
		Scanner leia = new Scanner(System.in);
		String data;
		
		ConsumoCrud crud = new ConsumoCrud();
		
		System.out.println("informe a data: ");
		data = leia.next();
		List<String> chati = crud.procurar(data);
		System.out.println(chati);
	}
}
