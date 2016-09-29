package br.com.grupo4.mutirapp.main;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.service.BuscaCEPServiceImpl;

public class BuscarCepTest {

	public static void main(String[] args) {
		Acao acao = new Acao();
		
		BuscaCEPServiceImpl bcep = BuscaCEPServiceImpl.getInstance();
		
		acao.setEndCep("54762330");
		
		bcep.preencherEndereco(acao, acao.getEndCep());
		
		System.out.println( acao );
		
	}
}
