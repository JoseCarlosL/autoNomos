package br.com.autonomos.modelo;

import java.util.Scanner;
import java.sql.Date;

public class Visitante extends Pessoa {

	Scanner entrada = new Scanner(System.in);

	public Visitante(int id, String nome, String email, String telefone,
			String cpf, Endereco endereco) {
		super(id, nome, email, telefone, endereco);
		super.setTipoPessoa("visitante");

	}

	public void solicitarAtendimento(int id_Visitante) {
		// RelatoDeAtendimento relato = new RelatoDeAtendimento();
	}

}
