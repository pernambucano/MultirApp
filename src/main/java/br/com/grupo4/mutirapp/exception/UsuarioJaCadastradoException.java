package br.com.grupo4.mutirapp.exception;


public class UsuarioJaCadastradoException extends Exception {

	String erro = "O usu�rio j� est� cadastrado";
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.erro;
	}
	
	
	 
}
