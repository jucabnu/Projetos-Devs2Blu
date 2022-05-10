package br.com.projetosaula.energia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetosaula.energia.data.dto.ContratoDTO;
import br.com.projetosaula.energia.data.entity.Contrato;
import br.com.projetosaula.energia.repository.ContratoRepository;


@Service
public class ContratoService {
	
	@Autowired
	ContratoRepository repository;
	
	public List<ContratoDTO> getAll() {
		List<Contrato> contratos = repository.findAll();
		List<ContratoDTO> listaNotasDTO = new ArrayList<>();
		
		for (Contrato contrato : contratos) {
			listaNotasDTO.add(contrato.getDTO());
		}
		return listaNotasDTO;
	}
	
	public ContratoDTO getById(Integer id) throws Exception {
		Contrato contrato = repository.findById(id)
								.orElseThrow(
										() -> new Exception("Contrato não encontrado"));
		return contrato.getDTO();
	}

	public ContratoDTO add(ContratoDTO contrato) {
		return repository.save(contrato.convertToEntity()).getDTO();
	}

	public Boolean delete(Integer id) throws Exception {
		repository.delete(getById(id).convertToEntity());
		return true;
	}

	public ContratoDTO update(ContratoDTO contrato) throws Exception {
		getById(contrato.getIdContrato());
		return add(contrato);
	}

}
