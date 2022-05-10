package br.com.projetosaula.energia.data.dto;

import java.io.Serializable;

import br.com.projetosaula.energia.data.entity.Contrato;

public class ContratoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idContrato;
	private UsuarioDTO usuarioContrato;
	private int unidadesGeradorasContrato;
	private float saldoCreditosContrato;
	private float totalCo2Contrato;
	
	public Contrato convertToEntity() {
		return new Contrato(getIdContrato(), getUsuarioContrato().convertToEntity(), 
				getUnidadesGeradorasContrato(), getSaldoCreditosContrato(), getTotalCo2Contrato());
	}
	
	public ContratoDTO() {}

	public ContratoDTO(Integer id, UsuarioDTO usuarioDTO, int unidadesGeradoras, float saldoCreditos, float totalCo2) {
		super();
		this.idContrato = id;
		this.usuarioContrato = usuarioDTO;
		this.unidadesGeradorasContrato = unidadesGeradoras;
		this.saldoCreditosContrato = saldoCreditos;
		this.totalCo2Contrato = totalCo2;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public UsuarioDTO getUsuarioContrato() {
		return usuarioContrato;
	}

	public void setUsuarioContrato(UsuarioDTO usuarioContrato) {
		this.usuarioContrato = usuarioContrato;
	}

	public int getUnidadesGeradorasContrato() {
		return unidadesGeradorasContrato;
	}

	public void setUnidadesGeradorasContrato(int unidadesGeradorasContrato) {
		this.unidadesGeradorasContrato = unidadesGeradorasContrato;
	}

	public float getSaldoCreditosContrato() {
		return saldoCreditosContrato;
	}

	public void setSaldoCreditosContrato(float saldoCreditosContrato) {
		this.saldoCreditosContrato = saldoCreditosContrato;
	}

	public float getTotalCo2Contrato() {
		return totalCo2Contrato;
	}

	public void setTotalCo2Contrato(float totalCo2Contrato) {
		this.totalCo2Contrato = totalCo2Contrato;
	}
	
}
