package br.com.projetosaula.energia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetosaula.energia.data.dto.UsuarioDTO;
import br.com.projetosaula.energia.data.entity.Usuario;
import br.com.projetosaula.energia.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public List<UsuarioDTO> getAll(){
		List<Usuario> usuarios = repository.findAll();
		List<UsuarioDTO> listaDTOs = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			listaDTOs.add(usuario.getDTO());
		}
		return listaDTOs;		
	}
	
	public UsuarioDTO getById(Integer id) throws Exception{
		Usuario usuario = repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado pelo ID " + id));
		return usuario.getDTO();
	}
	
	public UsuarioDTO getByNome(String nome) throws Exception{
		Usuario usuario = repository.findByNome(nome).orElseThrow(() -> new Exception("Usuário não encontrado pelo nome " + nome));
		return usuario.getDTO();
	}
	
	public UsuarioDTO getByLogin(String login) throws Exception{
		Usuario usuario = repository.findByLogin(login).orElseThrow(() -> new Exception("Usuário não encontrado pelo login " + login));
		return usuario.getDTO();
	}
	
	public UsuarioDTO getByEmail(String email) throws Exception{
		Usuario usuario = repository.findByEmail(email).orElseThrow(() -> new Exception("Usuário não encontrado pelo e-mail " + email));
		return usuario.getDTO();
	}
	
	public UsuarioDTO save(UsuarioDTO dto) {
		Usuario usuario = repository.save(dto.convertToEntity());
		return usuario.getDTO();
	}
	
	public Boolean delete(Integer idUsuario) throws Exception {
		Usuario usuario = repository.findById(idUsuario)
								  .orElseThrow(() -> new Exception("Usuário não encontrado"));
		repository.delete(usuario);
		return true;
	}

	public UsuarioDTO update(UsuarioDTO usuario) throws Exception {
		getById(usuario.getIdUsuario());
		return save(usuario);
	}
	

}
