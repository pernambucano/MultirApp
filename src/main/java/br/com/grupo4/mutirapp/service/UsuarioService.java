package br.com.grupo4.mutirapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;

@Component
public interface UsuarioService {
<<<<<<< HEAD
=======
	public List<Acao> listarAcoes(String email);
>>>>>>> 9990c91d3eb47c4ff9bffb052549a280a48d79f5
	public Usuario getUsuarioByEmail(String email);
	public void cadastrarUsuario(Usuario usuario);
	public void alterarUsuario(Usuario usuario);
	public void deleteUsuarioByEmail(String email);
	public List<Acao> getAcoesCadastradasPorEmail(String email);
	public List<Acao> getAcoesInteressadasPorEmail(String email);
	public void inserirInteresse(Usuario usuario, Acao a, Date data);
}
