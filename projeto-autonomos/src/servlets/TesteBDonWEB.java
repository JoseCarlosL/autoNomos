package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import relatorioDeConsumo.DataInicioRelatorio;
import conexao.Conexao;
import conexao.Energia;
import conexao.EnergiaCrud;
import controladores.ControladorRelatorio;

/**
 * Servlet implementation class TesteBDonWEB
 */
@WebServlet("/TesteBDonWEB")
public class TesteBDonWEB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TesteBDonWEB() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ControladorRelatorio controle = new ControladorRelatorio();
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(url);
			List<DataInicioRelatorio> contas = controle.procurarDataInicio(con);
			for (DataInicioRelatorio ener : contas) {
				System.out.println(ener);
				out.println(ener);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//doGet

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}//doPost

}
