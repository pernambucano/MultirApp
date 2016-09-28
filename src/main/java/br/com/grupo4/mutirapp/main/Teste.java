package br.com.grupo4.mutirapp.main;

import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.service.UsuarioService;
import br.com.grupo4.mutirapp.service.UsuarioServiceImpl;

public class Teste {
	public static void main(String[] args) {
		
		// Testando métodos do service de usuário
		
		UsuarioService us = new UsuarioServiceImpl();
		
		
//		public void cadastrarUsuario(Usuario usuario) - OK
		
		Usuario u1 = new Usuario("Paulo", "paulo@gmail.com", "12345", true);
		Usuario u2 = new Usuario("Pedro", "pedro@gmail.com", "12345", true);
		Usuario u3 = new Usuario("Joao", "joao@gmail.com", "12345", true);
		Usuario u4 = new Usuario("Marcos", "marcos@gmail.com", "12345", true);
		
		us.cadastrarUsuario(u1);
		us.cadastrarUsuario(u2);
		us.cadastrarUsuario(u3);
		us.cadastrarUsuario(u4);
		
//		public Usuario getUsuarioByEmail(String email) - OK
		
		Usuario teste1 = us.getUsuarioByEmail("paulo@gmail.com");
		System.out.println("Imprimindo o usuário de email 'paulo@gmail.com'");
		System.out.println(teste1.toString());
		
		
//		public void alterarUsuario(Usuario usuario); - OK
		
		Usuario teste2 = us.getUsuarioByEmail("paulo@gmail.com");
		teste2.setSenha("0981234");
		teste2.setEmail("paulo@hotmail.com");
		us.alterarUsuario(teste2);
		
//		public void deleteUsuarioByEmail(String email); - OK
		
		us.deleteUsuarioByEmail("joao@gmail.com");

		
		
		
	}
}
