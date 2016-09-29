package br.com.grupo4.mutirapp.exception;


public class UsuarioJaCadastradoException extends Exception {

	String erro = "O usuário já está cadastrado";
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.erro;
	}
	
	
	 
}
