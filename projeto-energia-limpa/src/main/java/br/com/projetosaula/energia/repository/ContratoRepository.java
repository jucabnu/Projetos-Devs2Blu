package br.com.projetosaula.energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetosaula.energia.data.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

}
