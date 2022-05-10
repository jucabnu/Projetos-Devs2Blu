package br.com.projetosaula.energia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetosaula.energia.data.entity.Contrato;
import br.com.projetosaula.energia.data.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
	
	//2022-05-07
	public List<Transacao> findByContrato (Contrato contrato);

}