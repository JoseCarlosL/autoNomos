package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.autonomos.modelox.servlet.ServletException;
import br.com.autonomos.modelox.servlet.annotation.WebServlet;
import br.com.autonomos.modelox.servlet.http.HttpServlet;
import br.com.autonomos.modelox.servlet.http.HttpServletRequest;
import br.com.autonomos.modelox.servlet.http.HttpServletResponse;
import conexao.Conexao;
import conexao.Energia;
import conexao.EnergiaCrud;

/**
 * Servlet implementation class TesteBDonWEB
 */
@WebServlet("/TesteBDonWEB")
public class TesteBDonWEB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TesteBDonWEB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		EnergiaCrud crud = new EnergiaCrud();
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(url);
			List<Energia> contas = crud.Ler(con);
			for (Energia ener : contas) {
				System.out.println(ener);
				out.println(ener);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
