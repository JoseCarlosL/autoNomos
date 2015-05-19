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

	private final String BUSCA_DATA_INICIO = "select data from relatorio where data = (?)";

	public Connection getConnection() throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";
		con = DriverManager.getConnection(url);
		return con;
	}// ABRIR

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}// CLOSE

	public String procurarDataInicial(String datap) throws SQLException {
		String dataRetorno = null;
		String sql = "select data from relatorio where data = (?)";
		Connection conne = null;
		try {
			conne = getConnection();
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
			closeConnection(conne);
		}

		return dataRetorno;

	}// BUSCAR DATA INICIAL

	public String procurarDataFinal(String datap) throws SQLException {
		String dataRetorno = null;
		String sql = "select data from relatorio where data = (?)";
		Connection conne = null;
		try {
			conne = getConnection();
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
			closeConnection(conne);
		}

		return dataRetorno;

	}// BUSCAR DATA FINAL

	public static void main(String[] args) throws SQLException, ParseException {
		ManipuladorBD mani = new ManipuladorBD();
		
		String data = "2015-05-09";
		String dataf = "2015-05-11";
		
		DataInicioRelatorio dates = new DataInicioRelatorio();
		
		String batata = mani.procurarDataInicial(data);
		String queijo = mani.procurarDataFinal(dataf);
		
		String datar = batata;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d = formatter.parse(datar);
		
		String dataz = queijo;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date a = formater.parse(dataz);
		
		System.out.println(batata + "\n" + queijo + "\n");
		System.out.println(d.getTime() - a.getTime());
	}
}
