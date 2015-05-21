package br.com.autonomos.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import relatorioDAO.Conexao;
import relatorioDeConsumo.DataFinalRelatorio;
import relatorioDeConsumo.DataInicioRelatorio;

public class ControladorRelatorio {
	
	public DataInicioRelatorio buscarDataInicial(String data);
	
	public DataFinalRelatorio buscarDataFinal(String data);
}
