package br.com.projetosaula.energia.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetosaula.energia.data.dto.UsuarioDTO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40, nullable = false)
	private String login;
	
	@Column(length = 40, nullable = false)
	private String senha;	
	
	@Column(length = 40, nullable = false)
	private String email;	
	
	private int tipo;
	private boolean ativo;
	private String nome;
	
	public Usuario() {}

	public Usuario(Integer id, String login, String senha, String email, int tipo, boolean ativo, String nome) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.tipo = tipo;
		this.ativo = ativo;
		this.nome = nome;
	}
	
	public UsuarioDTO getDTO() {
		return new UsuarioDTO(getId(), getLogin(), getSenha(), getEmail(), getTipo(), isAtivo(), getNome());
	}
	
	

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
