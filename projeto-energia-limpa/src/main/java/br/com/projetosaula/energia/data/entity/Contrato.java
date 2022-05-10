package br.com.projetosaula.energia.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.projetosaula.energia.data.dto.ContratoDTO;

@Entity
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private int unidadesGeradoras;
	private float saldo;
	private float totalCo2;
	
	public Contrato() {}
	
	public Contrato(Integer id, Usuario usuario, int unidadesGeradoras, float saldo, float totalCo2) {		
		this.id = id;
		this.usuario = usuario;
		this.unidadesGeradoras = unidadesGeradoras;
		this.saldo = saldo;
		this.totalCo2 = totalCo2;
	}
	
	public ContratoDTO getDTO() {
		return new ContratoDTO(getId(), getUsuario().getDTO(), getUnidadesGeradoras(), getSaldo(), getTotalCo2());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getUnidadesGeradoras() {
		return unidadesGeradoras;
	}

	public void setUnidadesGeradoras(int unidadesGeradoras) {
		this.unidadesGeradoras = unidadesGeradoras;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getTotalCo2() {
		return totalCo2;
	}

	public void setTotalCo2(float totalCo2) {
		this.totalCo2 = totalCo2;
	}
	
		

}
