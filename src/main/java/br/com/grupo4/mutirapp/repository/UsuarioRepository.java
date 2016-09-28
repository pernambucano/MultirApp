package br.com.grupo4.mutirapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.grupo4.mutirapp.model.Usuario;

@Component
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	Usuario findByEmail(String email);
	List<Usuario> findByName(String name);

}
