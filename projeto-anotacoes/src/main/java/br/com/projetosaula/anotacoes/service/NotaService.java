package br.com.projetosaula.anotacoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetosaula.anotacoes.data.dto.NotaDTO;
import br.com.projetosaula.anotacoes.data.entity.Nota;
import br.com.projetosaula.anotacoes.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	NotaRepository repository;
	
	public List<NotaDTO> getAll(){
		List<Nota> notas = repository.findAll();
		List<NotaDTO> listaNotasDTO = new ArrayList<>();
		// para cada resultado que vem do banco para devolver como DTO, de moto que a entidade não chegue no serviço
		for (Nota nota : notas) {
			listaNotasDTO.add(nota.getDTO());
			
		}
		return listaNotasDTO;
	}
	
	public NotaDTO getById(Integer id) throws Exception{
		Nota nota = repository.findById(id)
				.orElseThrow(
						() -> new Exception("Nota não encontrada"));
		return nota.getDTO();
	}

	public NotaDTO add(NotaDTO nota) {
		// return repository.save(nota.convertToEntity().getDTO());
		
		Nota notaSave = nota.convertToEntity();
		notaSave = repository.save(notaSave);
		return notaSave.getDTO();
		
	}	
}