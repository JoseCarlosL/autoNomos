package br.com.autonomos.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import br.com.autonomos.relatorioConsumo.ValoresDeBusca;
import relatorioDeConsumo.DataFinalRelatorio;
import relatorioDeConsumo.DataInicioRelatorio;

public class ManipuladorBD {

	private final String BUSCA_DATA_INICIO = "select data, kilowatt, valor from consumo where data = (?)";
	

	public Connection getConnection() throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		con = DriverManager.getConnection(url);
		return con;
	}// ABRIR 

	/*public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}// CLOSE*/

/*	public String procurarDataInicial(String datap) throws SQLException {
		String dataRetorno = null;
		String sql = "select data, kilowatt from consumo where data = (?)";
		Connection conne = null;
		try {
			//conne = getConnection();
			PreparedStatement stm = conne.prepareStatement(sql);
			stm.setString(1, datap);// seta a data para fazer a busca
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				Date valorDoBanco = rs.getDate(1);
				String dataz = "dd/MM/yyyy";
				SimpleDateFormat formatas = new SimpleDateFormat(dataz);
				String data = formatas.format(valorDoBanco);
				dataRetorno = data;
			}
		} finally {
			//closeConnection(conne);
		}

		return dataRetorno;

	}// BUSCAR DATA INICIAL
*/
	/*public String procurarDataFinal(String datap) throws SQLException {
		Connection con = null;
		String dataRetorno = null;
		String sar = null;
		List<String> retorno = new ArrayList<String>();
		List<Double> ret = new ArrayList<Double>();
		List<Double> re = new ArrayList<Double>();
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stm = conn.prepareStatement(BUSCA_DATA_INICIO);
			stm.setString(1, datap);// seta a data para fazer a busca
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				Date valorDoBanco = rs.getDate(1);
				double kw = rs.getDouble(2);
				double valor = rs.getDouble(3);
				int p = 1;
				p = p++;
				String dataz = "dd/MM/yyyy";
				SimpleDateFormat formatas = new SimpleDateFormat(dataz);
				String data = formatas.format(valorDoBanco);
				
				retorno.add(data);
				ret.add(kw);
				re.add(valor);
				
				sar = retorno + " , " + ret + " , " + re;
			}
		} finally {
			//closeConnection(con);
		}

		return sar;

	}// BUSCAR DATA FINAL*/
	public List<DataFinalRelatorio> listFinal = new ArrayList<DataFinalRelatorio>();
	
	public List<DataInicioRelatorio> listInicial = new ArrayList<DataInicioRelatorio>();
	
	public List<ValoresDeBusca> listValorBusca = new ArrayList<ValoresDeBusca>();
	
	static double soma;
	
	public List<DataInicioRelatorio> procurarDataInicial(String data) throws SQLException{
		
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		DataInicioRelatorio inicialDate = new DataInicioRelatorio();
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stm = conn.prepareStatement(BUSCA_DATA_INICIO);
			stm.setString(1, data);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				inicialDate.setDataInicio(rs.getDate("data"));
				inicialDate.setKilowatt(rs.getDouble("kilowatt"));
				inicialDate.setValor(rs.getDouble("valor"));
				
				listInicial.add(inicialDate);
				System.out.println(inicialDate);
			}
		}finally{
			//closeConnection(con);
		}
		
		return listInicial;
	}
	
	static long dias;
	
	public List<DataFinalRelatorio> procurarDataFinal(String data) throws SQLException {
		
		
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		DataFinalRelatorio finalDate = new DataFinalRelatorio();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stm = conn.prepareStatement(BUSCA_DATA_INICIO);
			stm.setString(1, data);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				
				finalDate.setDataFinal(rs.getDate("data"));
				finalDate.setKilowatt(rs.getDouble("kilowatt"));
				finalDate.setValor(rs.getDouble("valor"));
				
				listFinal.add(finalDate);
				System.out.println(finalDate);
			}
		} finally {
			//closeConnection(con);
		}

		return listFinal;

	}// BUSCAR DATA FINAL
	
	public List<ValoresDeBusca> buscador (String date1, String date2) throws SQLException{
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		String sss = "select sum(kilowatt), sum(valor) from consumo where data between (?) and (?)";
		
		ValoresDeBusca valorBusca = new ValoresDeBusca();
		Connection conn;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(url);
			PreparedStatement stm = conn.prepareStatement(sss);
			stm.setString(1, date1);
			stm.setString(2, date2);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				valorBusca.setKilowatt(rs.getDouble(1));
				valorBusca.setValor(rs.getDouble(2));
				listValorBusca.add(valorBusca);
				System.out.println(valorBusca);
			}
		} finally {
			//closeConnection(con);
		}
		
		return listValorBusca;
	}

	public static void main(String[] args) throws SQLException, ParseException {
		ManipuladorBD mani = new ManipuladorBD();
		
		String data = "2015-05-01";
		
		List<DataFinalRelatorio> cc = new ArrayList<DataFinalRelatorio>();
		List<DataInicioRelatorio> dd = new ArrayList<DataInicioRelatorio>();
		 
		dd = mani.procurarDataInicial("2015-05-08");
		cc = mani.procurarDataFinal(data);
			
		for(DataFinalRelatorio d : mani.listFinal){
			System.out.println(d.getDataFinal());
			System.out.println(d.getKilowatt());
			System.out.println(d.getValor());
			
			for(DataInicioRelatorio x: mani.listInicial){
				System.out.println(x.getDataInicio()+".");
				System.out.println(x.getKilowatt()+".");
				System.out.println(x.getValor()+".");
				
				long resultado = x.getDataInicio().getTime() - d.getDataFinal().getTime();
				 dias = resultado/86400000L;
			}
		}
		System.out.println(dias);
		System.out.println("\n--------------------------\n");
		
		for(DataInicioRelatorio d: mani.listInicial){
			System.out.println(d.getDataInicio());
			System.out.println(d.getKilowatt());
			System.out.println(d.getValor());
		}
		
		System.out.println("\n ------------------------ \n");
		
	 mani.buscador("2015-05-01","2015-05-05");
		
		System.out.println(soma);

	/*	String data = "2015-05-01";
		String dataf = "2015-05-10";
		
		DataInicioRelatorio dates = new DataInicioRelatorio();
		
		String inicio = mani.procurarDataInicial(data);
		String fim = mani.procurarDataFinal(dataf);
		System.out.println(inicio);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d = new Date (formatter.parse(inicio).getTime());
		System.out.println(d);
		System.out.println();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date a = new Date (formater.parse(fim).getTime());
		System.out.println(a);
		System.out.println();
		
		long resultado = a.getTime() - d.getTime();//compara o tempo entre as datas inicio e fim
		long dias = resultado / 86400000L;//Divide o resultado para pegar apenas o dias de diferença
		System.out.println(dias);
		System.out.println();
		System.out.println(inicio + "\n" + fim + "\n");
		System.out.println(d.getTime() - a.getTime());
	*/
	
	}

}
