package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> getAll(){
		return pessoaRepository.findAll();
	}
	
	public PessoaController() {	}

}
