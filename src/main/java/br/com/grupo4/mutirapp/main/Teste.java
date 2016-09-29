package br.com.grupo4.mutirapp.main;

import java.util.Date;
import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.TipoCategoria;
import br.com.grupo4.mutirapp.model.TipoStatus;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.service.AcaoService;
import br.com.grupo4.mutirapp.service.AcaoServiceImpl;
import br.com.grupo4.mutirapp.service.UsuarioService;
import br.com.grupo4.mutirapp.service.UsuarioServiceImpl;

public class Teste {
	public static void main(String[] args) {
		
		// Testando métodos do service de Usuário
		
		UsuarioService us = new UsuarioServiceImpl();
		
		
		// public void cadastrarUsuario(Usuario usuario) - OK
		
		Usuario u1 = new Usuario("Paulo", "paulo@gmail.com", "12345", true);
		Usuario u2 = new Usuario("Pedro", "pedro@gmail.com", "12345", true);
		Usuario u3 = new Usuario("Joao", "joao@gmail.com", "12345", true);
		Usuario u4 = new Usuario("Marcos", "marcos@gmail.com", "12345", true);
		
		us.cadastrarUsuario(u1);
		us.cadastrarUsuario(u2);
		us.cadastrarUsuario(u3);
		us.cadastrarUsuario(u4);
		
		// public Usuario getUsuarioByEmail(String email) - OK
		
		Usuario teste1 = us.getUsuarioByEmail("paulo@gmail.com");
		System.out.println("Imprimindo o usuário de email 'paulo@gmail.com'");
		System.out.println(teste1.toString());
		
		
		// public void alterarUsuario(Usuario usuario); - OK
		
		Usuario teste2 = us.getUsuarioByEmail("paulo@gmail.com");
		teste2.setSenha("0981234");
		teste2.setEmail("paulo@hotmail.com");
		us.alterarUsuario(teste2);
		
		// public void deleteUsuarioByEmail(String email); - OK
		
		us.deleteUsuarioByEmail("joao@gmail.com");
		
		// --------------------------------------------
		
		// Testando métodos do service de Ação
		
		AcaoService as = new AcaoServiceImpl();
		
		// public void cadastrarAcao(Acao acao); - OK
		
		Acao acaoTeste1 = new Acao(u1,TipoCategoria.MEIO_AMBIENTE,"Limpar a praça", "Precisamos limpar a praça", new Date(), new Date(), "50711340", "PE", "Recife", "Rua orós", "Cordeiro", TipoStatus.EM_ABERTO);
		Acao acaoTeste2 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar caes de rua", "Precisamos ajudar os animais", new Date(), new Date(), "50711421", "PE", "Recife", "Rua Cordeiro", "Ibura", TipoStatus.EM_ABERTO);
		
		as.cadastrarAcao(acaoTeste1);
		as.cadastrarAcao(acaoTeste2);
		
		// public Acao getAcaoByTitulo(String titulo); - OK 
		
		System.out.println(as.getAcaoByTitulo("Limpar a praça").getDescricao());
		

		// public void alterarAcao(Acao acao); - OK
		
		Acao acaoTeste2Alt = as.getAcaoByTitulo("Alimentar caes de rua");
		acaoTeste2Alt.setCategoria(TipoCategoria.OUTROS);
		as.alterarAcao(acaoTeste2Alt);
		
		// public void deleteAcaoByTitulo(String titulo); - OK
		
		as.deleteAcaoByTitulo("Alimentar caes de rua");
		
		// public List<Acao> listarTodasAcoes();
		
		List<Acao> lista = as.listarTodasAcoes();
		System.out.println("Imprimindo a lista de todas as acoes:");
		for(Acao a : lista){
			System.out.println(a.getTitulo());
		}

	}
}
