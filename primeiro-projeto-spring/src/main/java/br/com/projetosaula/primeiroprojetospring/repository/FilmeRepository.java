package br.com.projetosaula.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetosaula.primeiroprojetospring.entity.Filme;

// Filme é a classe, e o ID/tipo é o tipo do atributo ID
@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	//public Filme findById(Long id);
	
	//public Filme findByTitulo(String titulo);
	
	public Filme findByGenero(String genero);
	
	//public Filme findByGeneroAndRestricao(String genero, int restricao);

}
