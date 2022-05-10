package br.com.projetosaula.energia.data.dto;

import java.io.Serializable;
import java.sql.Date;

import br.com.projetosaula.energia.data.entity.Transacao;

public class TransacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idTransacaoDTO;
	private ContratoDTO contratoTransacao;
	private float lancamentoTransacao;
	private Date dataTransacao;
	
	public TransacaoDTO() {}
	
	public TransacaoDTO(Integer idTransacaoDTO, ContratoDTO contrato, float lancamento, Date data) {
		this.idTransacaoDTO = idTransacaoDTO;
		this.contratoTransacao = contrato;
		this.lancamentoTransacao = lancamento;
		this.dataTransacao = data;
	}
	
	public Transacao convertToEntity() {
		return new Transacao(getIdTransacaoDTO(),getContratoTransacao().convertToEntity(),getLancamentoTransacao(),getDataTransacao());
	}

	public Integer getIdTransacaoDTO() {
		return idTransacaoDTO;
	}

	public void setIdTransacaoDTO(Integer idTransacaoDTO) {
		this.idTransacaoDTO = idTransacaoDTO;
	}

	public ContratoDTO getContratoTransacao() {
		return contratoTransacao;
	}

	public void setContratoTransacao(ContratoDTO contratoTransacao) {
		this.contratoTransacao = contratoTransacao;
	}

	public float getLancamentoTransacao() {
		return lancamentoTransacao;
	}

	public void setLancamentoTransacao(float lancamentoTransacao) {
		this.lancamentoTransacao = lancamentoTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

		

}
