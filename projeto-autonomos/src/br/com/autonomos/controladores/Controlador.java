package br.com.autonomos.controladores;

import br.com.autonomos.relatorioConsumo.ValoresDeBusca;

public class Controlador {

	ValoresDeBusca busca = new ValoresDeBusca();
	
	public double valor (String dataInicio, String dataFinal){
		return busca.getKilowatt();
	}
}
