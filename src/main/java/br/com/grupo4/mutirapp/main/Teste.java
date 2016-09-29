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
		
		// Testando m√©todos do service de Usu√°rio
		
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
		System.out.println("Imprimindo o usu√°rio de email 'paulo@gmail.com'");
		System.out.println(teste1.toString());
		
		
		// public void alterarUsuario(Usuario usuario); - OK
		
		Usuario teste2 = us.getUsuarioByEmail("paulo@gmail.com");
		teste2.setSenha("0981234");
		teste2.setEmail("paulo@hotmail.com");
		us.alterarUsuario(teste2);
		
		// public void deleteUsuarioByEmail(String email); - OK
		
		us.deleteUsuarioByEmail("joao@gmail.com");
		
		// --------------------------------------------
		
		// Testando m√©todos do service de A√ß√£o
		
		AcaoService as = new AcaoServiceImpl();
		
		// public void cadastrarAcao(Acao acao); - OK
		
		Acao acaoTeste1 = new Acao(u1,TipoCategoria.MEIO_AMBIENTE,"Limpar a praia", "Precisamos limpar a pra√ßa", new Date(1475111860), new Date(1475111860), "50711340", "PE", "Recife", "Rua or√≥s", "Cordeiro", TipoStatus.EM_ABERTO);
		Acao acaoTeste2 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar caes de rua", "Precisamos ajudar os animais", new Date(1475111864), new Date(1475111864), "50711421", "PE", "Recife", "Rua Cordeiro", "Ibura", TipoStatus.EM_ABERTO);
		
		as.cadastrarAcao(acaoTeste1);
		as.cadastrarAcao(acaoTeste2);
		
		// public Acao getAcaoByTitulo(String titulo); - OK 
		
		System.out.println(as.getAcaoByTitulo("Limpar a praia").getDescricao());
		

		// public void alterarAcao(Acao acao); - OK
		
		Acao acaoTeste2Alt = as.getAcaoByTitulo("Alimentar caes de rua");
		acaoTeste2Alt.setCategoria(TipoCategoria.OUTROS);
		as.alterarAcao(acaoTeste2Alt);
		
		// public void deleteAcaoByTitulo(String titulo); - OK
		
		as.deleteAcaoByTitulo("Alimentar caes de rua");
		
		// Cadastrando acao de novo pra ter mais dados pros pr√≥ximos testes
		
		Acao acaoTeste3 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar caes de rua", "Precisamos ajudar os animais", new Date(1475111864), new Date(1475111864), "50711421", "PE", "Recife", "Rua Cordeiro", "Ibura", TipoStatus.EM_ABERTO);
		Acao acaoTeste4 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar gatos de rua", "Precisamos ajudar os animais", new Date(1475211885), new Date(1475111885), "50711432", "PE", "Recife", "Rua Cavalo", "Entrapusso", TipoStatus.EM_ABERTO);
		Acao acaoTeste5 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar lagartos de rua", "Precisamos ajudar os animais", new Date(1475311900), new Date(1475111900), "50743421", "PE", "Recife", "Rua Aligator", "Coque", TipoStatus.EM_ABERTO);
		Acao acaoTeste6 = new Acao(u2,TipoCategoria.ANIMAIS,"Alimentar girafas de rua", "Precisamos ajudar os animais", new Date(1475411909), new Date(1475111909), "50711651", "PE", "Recife", "Rua Gato", "Centro", TipoStatus.EM_ABERTO);

		as.cadastrarAcao(acaoTeste3);
		as.cadastrarAcao(acaoTeste4);
		as.cadastrarAcao(acaoTeste5);
		as.cadastrarAcao(acaoTeste6);
		
		
		// public List<Acao> listarTodasAcoes(); - OK
		
		
		List<Acao> lista = as.listarTodasAcoes();
		System.out.println("Imprimindo a lista de todas as acoes:");
		for(Acao a : lista){
			System.out.println(a.getTitulo());
		}
		
		// public List<Acao> getUltimasAcoes();  - OK
		
		List<Acao> lista2 = as.getUltimasAcoes(3); // 3 acoes
		System.out.println("Imprimindo a lista das 3 ultimas acoes:");
		for(Acao a : lista2){
			System.out.println(a.getTitulo() + " : " + a.getDataCadastro());
		}
		
		// MÈtodos de Usu·rio que tem relaÁ„o com AÁ„o/Interesse
		
		// public List<Acao> getAcoesCadastradasPorEmail(String email); - OK
		
		List<Acao> lista3 =  us.getAcoesCadastradasPorEmail(u2.getEmail()); // 3 acoes
		System.out.println("Imprimindo a lista de acoes criadas por" +  u2.getEmail());
		for(Acao a : lista3){
			System.out.println(a.getTitulo() + " : " + a.getDataCadastro());
		}
		
		// Criando interesses
		
		// public void inserirInteresse(Usuario usuario, Acao a, Date data);
		
		
		us.inserirInteresse(u2, acaoTeste1, new Date());
		us.inserirInteresse(u1, acaoTeste3, new Date());
		us.inserirInteresse(u1, acaoTeste4, new Date());
		

		
		
		// public List<Acao> getAcoesInteressadasPorEmail(String email);
		
		List<Acao> lista4 =  us.getAcoesInteressadasPorEmail(u1.getEmail()); // 3 acoes
		System.out.println("Imprimindo a lista de acoes interessadas por " +  u1.getEmail());
		for ( Acao a : lista4) {
			System.out.println(a.getTitulo());
		}
		// public void inserirInteresse(Usuario usuario, Acao a, Date data);
	}
}
