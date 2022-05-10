package br.com.projetosaula.energia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetosaula.energia.data.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByNome(String nome);
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByLogin(String login);	
	Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
	

}
