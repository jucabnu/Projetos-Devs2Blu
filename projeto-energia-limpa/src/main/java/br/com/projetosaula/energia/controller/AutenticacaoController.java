package br.com.projetosaula.energia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.energia.data.dto.LoginDTO;
import br.com.projetosaula.energia.data.dto.SignUpDTO;
import br.com.projetosaula.energia.data.entity.Usuario;
import br.com.projetosaula.energia.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/logar")
	public ResponseEntity<String> autenticarUsuario(@RequestBody LoginDTO loginDto){
		Authentication autenticacao = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getLoginOuEmail(), loginDto.getSenha()));
		
		SecurityContextHolder.getContext().setAuthentication(autenticacao);
		return new ResponseEntity<>("Usuário autenticado com sucesso!", HttpStatus.OK);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> criarUsuario(@RequestBody SignUpDTO signUpDto){

        // verifica se o usuario existe no BD
        if(usuarioRepository.existsByLogin(signUpDto.getLogin())){
            return new ResponseEntity<>("Login já existe!!", HttpStatus.BAD_REQUEST);
        }

        // verifica se o e-mail já existe no BD
        if(usuarioRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("E-mail já existe!", HttpStatus.BAD_REQUEST);
        }

        // Criar o objeto
        Usuario usuario = new Usuario();
        usuario.setNome(signUpDto.getNome());
        usuario.setLogin(signUpDto.getLogin());
        usuario.setEmail(signUpDto.getEmail());
        usuario.setSenha(passwordEncoder.encode(signUpDto.getSenha()));

        //Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        //usuario.setRoles(Collections.singleton(roles));

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Usuário registrado com sucesso!", HttpStatus.OK);

    }
	
	
	

	
}
