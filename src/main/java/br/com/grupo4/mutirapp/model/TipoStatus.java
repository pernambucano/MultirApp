package br.com.grupo4.mutirapp.model;

public enum TipoStatus {
	FINALIZADA("finalizada"),
	CANCELADA("cancelada"),
	EM_ABERTO("em_aberto");
	
	private String tipo;
	
	TipoStatus(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
}
