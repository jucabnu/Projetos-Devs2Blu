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

import br.com.projetosaula.energia.data.dto.UsuarioDTO;
import br.com.projetosaula.energia.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;

	@GetMapping
	public List<UsuarioDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO getById(@PathVariable("id") Integer id) throws Exception {
		return service.getById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public UsuarioDTO getByNome(@PathVariable("nome") String nome) throws Exception {
		return service.getByNome(nome);
	}
	
	@GetMapping("/login/{login}")
	public UsuarioDTO getByLogin(@PathVariable("login") String login) throws Exception {
		return service.getByLogin(login);
	}
	
	@GetMapping("/email/{email}")
	public UsuarioDTO getByEmail(@PathVariable("email") String email) throws Exception {
		return service.getByEmail(email);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuario) {
		return new ResponseEntity<UsuarioDTO>(service.save(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer idUsuario) throws Exception {
		return new ResponseEntity<>(service.delete(idUsuario), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuario) throws Exception{
		return new ResponseEntity<>(service.update(usuario), HttpStatus.OK);
	}
	
}
