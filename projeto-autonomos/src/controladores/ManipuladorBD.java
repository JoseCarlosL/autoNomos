package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

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

	public String procurarDataInicial(String datap) throws SQLException {
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

	public String procurarDataFinal(String datap) throws SQLException {
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

	}// BUSCAR DATA FINAL

	public static void main(String[] args) throws SQLException, ParseException {
		ManipuladorBD mani = new ManipuladorBD();
		
		String data = "2015-05-01";
		
		String saida = mani.procurarDataFinal(data);
		System.out.println(saida);

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
