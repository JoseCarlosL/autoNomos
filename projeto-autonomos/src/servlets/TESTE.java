package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import relatorioDAO.Conexao;
import relatorioDeConsumo.DataInicioRelatorio;
import controladores.ControladorRelatorio;

/**
 * Servlet implementation class TESTE
 */
@WebServlet("/TESTE")
public class TESTE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TESTE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ControladorRelatorio controle = new ControladorRelatorio();
		Conexao conexao = new Conexao();
		String url = "jdbc:mysql://localhost/testhome?user=root&password=carlos";

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(url);
			
			List<DataInicioRelatorio> contas = conexao.procurarInicio(con);
			for (DataInicioRelatorio ener : contas) {
				System.out.println(ener);
				out.println(ener);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
