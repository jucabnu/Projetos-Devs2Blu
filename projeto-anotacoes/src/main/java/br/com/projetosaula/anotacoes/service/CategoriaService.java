package br.com.projetosaula.anotacoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetosaula.anotacoes.data.dto.CategoriaDTO;
import br.com.projetosaula.anotacoes.data.entity.Categoria;
import br.com.projetosaula.anotacoes.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	public List<CategoriaDTO> getAll(){
		List<Categoria> categorias = repository.findAll();
		List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();
		for (Categoria categoria : categorias) {
			listaCategoriasDTO.add(categoria.getDTO());
		}
		return listaCategoriasDTO;
	}
	
	public CategoriaDTO getById(Integer id) throws Exception{
		Categoria categoria = repository.findById(id)
				.orElseThrow(
						() -> new Exception("Categoria não encontrada"));
		return categoria.getDTO();
	}
	
	public CategoriaDTO save(CategoriaDTO dto) {
		Categoria categoria = repository.save(dto.convertToEntity());
		return categoria.getDTO();
	}
}
