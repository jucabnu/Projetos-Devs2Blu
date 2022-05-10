package br.com.projetosaula.energia.data.dto;

import java.io.Serializable;

import br.com.projetosaula.energia.data.entity.Usuario;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private int tipoUsuario;
	private boolean ativoUsuario;
	private String nomeUsuario;
	
	public Usuario convertToEntity() {
		return new Usuario(getIdUsuario(), getLoginUsuario(), getSenhaUsuario(),
				getEmailUsuario(), getTipoUsuario(), isAtivoUsuario(), getNomeUsuario());
	}
	
	public UsuarioDTO() {}

	public UsuarioDTO(Integer id, String login, String senha, String email, int tipo, boolean ativo, String nome) {		
		this.idUsuario = id;
		this.loginUsuario = login;
		this.senhaUsuario = senha;
		this.emailUsuario = email;
		this.tipoUsuario = tipo;
		this.ativoUsuario = ativo;
		this.nomeUsuario = nome;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean isAtivoUsuario() {
		return ativoUsuario;
	}

	public void setAtivoUsuario(boolean ativoUsuario) {
		this.ativoUsuario = ativoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	

}
