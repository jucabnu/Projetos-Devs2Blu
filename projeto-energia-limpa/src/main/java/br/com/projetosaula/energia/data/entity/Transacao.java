package br.com.projetosaula.energia.data.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.projetosaula.energia.data.dto.TransacaoDTO;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_contrato")
	private Contrato contrato;
	
	private float lancamento;
	private Date data;
	
	public Transacao() {}

	public Transacao(Integer id, Contrato contrato, float lancamento, Date data) {
		this.id = id;
		this.contrato = contrato;
		this.lancamento = lancamento;
		this.data = data;
	}
	
	public Transacao(Contrato contrato, float lancamento, Date data) {
		this.contrato = contrato;
		this.lancamento = lancamento;
		this.data = data;
	}
	
	public TransacaoDTO getDTO() {
		return new TransacaoDTO(getId(), getContrato().getDTO(), getLancamento(),getData());
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public float getLancamento() {
		return lancamento;
	}

	public void setLancamento(float lancamento) {
		this.lancamento = lancamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
