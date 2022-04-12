package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Aluno;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.AlunoRepository;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Aluno> getAll(){
		return alunoRepository.findAll();
	}	
	
	@PostMapping
	public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno){
		Pessoa pessoaAluno = pessoaRepository.save(aluno.getPessoa());
		aluno.setPessoa(pessoaAluno);
		//aluno.getPessoa().setId(pessoaAluno.getId());		
		Aluno alunoResponse = alunoRepository.save(aluno);
		return new ResponseEntity<Aluno>(alunoResponse, HttpStatus.CREATED);		
	}
}
