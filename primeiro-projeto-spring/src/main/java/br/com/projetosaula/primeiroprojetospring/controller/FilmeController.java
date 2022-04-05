package br.com.projetosaula.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.primeiroprojetospring.entity.Filme;
import br.com.projetosaula.primeiroprojetospring.repository.FilmeRepository;

// O controller é o próprio servlet

/*
 @RequestMapping(“/filmes”) aqui para a classe geral, e vai para o método que tem @GetMapping sem parâmetros.
Métodos com @GetMapping(“/outracoisa”) como @GetMapping(“/{filme}”) fazem o redirecionamento.
*/

@CrossOrigin("*")
@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	// injeção da interface (ligação
	@Autowired
	FilmeRepository filmeRepository;

	public FilmeController() {}
	
	// aqui vai o CRUD
	// GetMapping vai gerenciar essa rota pra GET
	@GetMapping
	public List<Filme> getList(){		
		return filmeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Filme getFilmeById(@PathVariable("id") Long id) throws Exception {				
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new Exception("Filme não encontrado: " + id));		
		return filme;
	}
	
	@PostMapping	
	@ResponseStatus(code = HttpStatus.CREATED) // Gerar a respota Http no header 201 = criado!
	public boolean saveFilme(@RequestBody Filme filme) throws Exception {
		if(filme == null) {
			throw new Exception("Dados não enviados");
		}		
		filmeRepository.save(filme);
		return true;
	}
	
	// update, usando save, no caso, se o objeto tem Id, ele entende que é um update
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED) // Gerar a respota Http no header
	public boolean editFilme(@RequestBody Filme filme) throws Exception {
		if(filme.getId() == null) {
			throw new Exception("Registro sem Id");
		}		
		
		filmeRepository.findById(filme.getId()).orElseThrow(
				() -> new Exception("Registro (Id) não encontrado"));
		
		filmeRepository.save(filme);
		return true;
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteFilme(@RequestBody Long id) throws Exception{
		filmeRepository.findById(id).orElseThrow(
				() -> new Exception("Registro (Id) não encontrado"));
		filmeRepository.deleteById(id);
		return true;
	}
	
}