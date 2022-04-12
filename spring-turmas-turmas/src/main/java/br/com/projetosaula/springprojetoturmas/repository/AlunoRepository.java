package br.com.projetosaula.springprojetoturmas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.projetosaula.springprojetoturmas.entity.Aluno;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	//public List<Pessoa> findByNomeAndTurma(String nome, String turma);

}
