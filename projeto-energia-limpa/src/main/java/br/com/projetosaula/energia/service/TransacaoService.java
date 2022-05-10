package br.com.projetosaula.energia.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetosaula.energia.data.dto.ContratoDTO;
import br.com.projetosaula.energia.data.dto.TransacaoDTO;
import br.com.projetosaula.energia.data.entity.Contrato;
import br.com.projetosaula.energia.data.entity.Transacao;
import br.com.projetosaula.energia.repository.ContratoRepository;
import br.com.projetosaula.energia.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	TransacaoRepository repository;
	
	@Autowired
	ContratoRepository contratoRepository;
	
	public List<TransacaoDTO> getAll() {
		List<Transacao> transacoes = repository.findAll();
		List<TransacaoDTO> listaTransacoesDTO = new ArrayList<>();
		
		for (Transacao transacao : transacoes) {
			listaTransacoesDTO.add(transacao.getDTO());
		}
		return listaTransacoesDTO;
	}
	
	// 2022-05-07
	public List<TransacaoDTO> getAllTransactionsByContratoId(Integer id) {
		Contrato contrato = contratoRepository.getById(id);
		List<Transacao> transacoes = repository.findByContrato(contrato);
		List<TransacaoDTO> listaTransacoesDTO = new ArrayList<>();
		
		for (Transacao transacao : transacoes) {
			listaTransacoesDTO.add(transacao.getDTO());
		}
		return listaTransacoesDTO;
	}
	
	
	
	
	public TransacaoDTO getById(Integer id) throws Exception {
		Transacao transacao = repository.findById(id)
								.orElseThrow(
										() -> new Exception("Transacao não encontrada"));
		return transacao.getDTO();
	}

	// 2022-05-07
	public TransacaoDTO add(TransacaoDTO transacao) {
		
		Contrato contrato = contratoRepository.getById(transacao.getContratoTransacao().getIdContrato());
		ContratoDTO contratoDTO = contrato.getDTO();
		
		// aumenta ou diminui o saldo conforme o lançamento
		contratoDTO.setSaldoCreditosContrato(contratoDTO.getSaldoCreditosContrato() + transacao.getLancamentoTransacao());
		
//		Aumenta o total de Co2 que se deixou de emitir a cada operação positiva. 
//		Fator de conversão ficou hard code. Deverá ser posta uma variável, pois é uma métrica que pode variar com o tempo
		if(transacao.getLancamentoTransacao() >= 0) {
			contratoDTO.setTotalCo2Contrato( contratoDTO.getTotalCo2Contrato() + (float)(transacao.getLancamentoTransacao() / 2.314 ));			
		}
		contratoRepository.save(contratoDTO.convertToEntity());
		
		return repository.save(transacao.convertToEntity()).getDTO();
	}
	
	// 2022-05-09
	public List<TransacaoDTO> addCreditosDoMes(Float kwhPorUnidade) {
		
		List<Contrato> contratos = contratoRepository.findAll();
		List<TransacaoDTO> transacoes = new ArrayList<>();
		
		for (Contrato contrato : contratos) {
			int unidadesGeradoras = contrato.getUnidadesGeradoras();
			float valorLancamento = unidadesGeradoras * kwhPorUnidade;
			
			contrato.setTotalCo2(contrato.getTotalCo2() + (float)(valorLancamento / 2.314) );
			contrato.setSaldo(contrato.getSaldo() + valorLancamento);
			
			Transacao transacao = new Transacao(contrato, valorLancamento, this.informaDataAtual());
			repository.save(transacao);
			transacoes.add(transacao.getDTO());
		}
		return transacoes;
	}
	
	public java.sql.Date informaDataAtual() {
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        return new java.sql.Date(timeInMilliSeconds);
	}

	public Boolean delete(Integer id) throws Exception {
		repository.delete(getById(id).convertToEntity());
		return true;
	}

	public TransacaoDTO update(TransacaoDTO transacao) throws Exception {
		getById(transacao.getIdTransacaoDTO());
		return add(transacao);
	}

}
