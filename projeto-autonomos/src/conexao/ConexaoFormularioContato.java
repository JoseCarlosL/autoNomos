package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autonomos.modelo.RelatoDeAtendimento;

public class ConexaoFormularioContato {

	public void criar(Connection con, RelatoDeAtendimento atendimento)
			throws SQLException {

		String sql = "insert into form_contato values (?, ?, ?, ?, ?)";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(2, atendimento.getNome());
			stm.setString(3, atendimento.getEmail());
			stm.setString(4, atendimento.getTelefone());
			stm.setString(5, atendimento.getData());
			stm.setString(6, atendimento.getDuvida());

			stm.executeUpdate();

		}

	}

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql//localhost/testecontato?user=root&password=root";

		try (Connection con = DriverManager.getConnection(url)) {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			ConexaoFormularioContato crud = new ConexaoFormularioContato();
			RelatoDeAtendimento rela1 = new RelatoDeAtendimento("jao",
					"juj@da", "999", "hoje", "nenhuma");

			crud.criar(con, rela1);
			System.out.println("Ola Mundo");
		}
	}

}
