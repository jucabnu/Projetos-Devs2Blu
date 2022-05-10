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

import br.com.projetosaula.energia.data.dto.TransacaoDTO;
import br.com.projetosaula.energia.service.TransacaoService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/transacao")
public class TransacaoController {
	
	@Autowired
	TransacaoService service;
	
	@GetMapping
	public List<TransacaoDTO> getAll() {
		return service.getAll();
	}
	
	// 2022-05-07
	@GetMapping("/getByContratoId/{idContrato}") // busca todas transacoes pelo id do contrato
	public List<TransacaoDTO> getAllTransactionsByContratoId(@PathVariable("idContrato") Integer idContrato ) throws Exception {
		return service.getAllTransactionsByContratoId(idContrato);
	}
	
	@GetMapping("/{id}") // busca uma transacao pelo id da transacao
	public TransacaoDTO getById(@PathVariable("id") Integer id) throws Exception {
		return service.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<TransacaoDTO> addTransacao(@RequestBody TransacaoDTO transacao) {
		return new ResponseEntity<>(service.add(transacao), HttpStatus.CREATED);
	}
	
	@PostMapping("/creditos-em-lote/{valorPorUnidade}")
	public ResponseEntity<List<TransacaoDTO>> addEmLote(@PathVariable("valorPorUnidade") Float valor) {
		return new ResponseEntity<>(service.addCreditosDoMes(valor), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<TransacaoDTO> update(@RequestBody TransacaoDTO transacao) throws Exception{
		return new ResponseEntity<>(service.update(transacao), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delTransacao(@PathVariable("id") Integer id) throws Exception{
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
