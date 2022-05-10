package br.com.projetosaula.energia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetosaula.energia.data.dto.ContratoDTO;
import br.com.projetosaula.energia.service.ContratoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contrato")
public class ContratoController {

	@Autowired
	ContratoService service;
	
	@GetMapping
	public List<ContratoDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ContratoDTO getById(@PathVariable("id") Integer id) throws Exception {
		return service.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<ContratoDTO> addContrato(@RequestBody ContratoDTO contrato) {
		return new ResponseEntity<>(service.add(contrato), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ContratoDTO> update(@RequestBody ContratoDTO contrato) throws Exception{
		return new ResponseEntity<>(service.update(contrato), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delContrato(@PathVariable("id") Integer id) throws Exception{
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
