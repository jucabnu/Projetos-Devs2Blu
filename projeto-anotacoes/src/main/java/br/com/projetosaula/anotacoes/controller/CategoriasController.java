package br.com.projetosaula.anotacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.anotacoes.data.dto.CategoriaDTO;
import br.com.projetosaula.anotacoes.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categoria")
public class CategoriasController {
	
	@Autowired
	CategoriaService service;
	
	@GetMapping
	public List<CategoriaDTO> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public CategoriaDTO getById(@PathVariable("id") Integer id) throws Exception {
		return service.getById(id);
	}
	
	public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoria){
		return new ResponseEntity<CategoriaDTO>(service.save(categoria), HttpStatus.CREATED);
	}

	public CategoriasController() {}

}
