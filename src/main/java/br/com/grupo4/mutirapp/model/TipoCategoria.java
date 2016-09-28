package br.com.grupo4.mutirapp.model;

public enum TipoCategoria {
	ANIMAIS("animais"),
	MEIO_AMBIENTE("meio_ambiente"),
	OUTROS("outros");
	
	private String tipo;
	
	TipoCategoria(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
}
