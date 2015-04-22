package classesWeb;

import java.util.Scanner;
import java.sql.Date;

public class Visitante extends Pessoa {

	Scanner entrada = new Scanner(System.in);

	public Visitante(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco) {
		super(id, nome, email, telefone, cpf, endereco);

	}

	public void solicitarAtendimento(int id_Visitante) {
		
	}

}
