package dw.trabalho.service;

import dw.trabalho.model.Jogador;
import dw.trabalho.model.Pagamento;
import dw.trabalho.repository.JogadorRepository;
import dw.trabalho.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.math.BigDecimal;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    public record PagamentoComNomeDTO(Long cod_pagamento, Integer ano, Integer mes,
                                      BigDecimal valor, Integer cod_jogador, String nome_jogador) {}

    public List<?> listarTodos(Long jogadorId) {
        if (jogadorId != null) {
            return pagamentoRepository.findByJogadorCodJogador(jogadorId.intValue()).stream()
                .map(p -> new PagamentoComNomeDTO(p.getCod_pagamento(), p.getAno(), p.getMes(),
                        p.getValor(), p.getJogador().getCodJogador(), p.getJogador().getNome()))
                .toList();
        }
        return pagamentoRepository.findAll().stream()
            .map(p -> new PagamentoComNomeDTO(p.getCod_pagamento(), p.getAno(), p.getMes(),
                    p.getValor(), p.getJogador().getCodJogador(), p.getJogador().getNome()))
            .toList();
    }

    public PagamentoComNomeDTO criar(Pagamento pagamento) {
        if (pagamento.getAno() == null || pagamento.getMes() == null ||
            pagamento.getValor() == null || pagamento.getJogador() == null ||
            pagamento.getJogador().getCodJogador() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ano, mes, valor e cod_jogador são obrigatórios");
        }

        Integer codJogador = pagamento.getJogador().getCodJogador();
        Jogador jogador = jogadorRepository.findById(codJogador)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));

        if (pagamentoRepository.existsByJogadorCodJogadorAndAnoAndMes(codJogador, pagamento.getAno(), pagamento.getMes())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Pagamento já existe para este jogador neste mês/ano");
        }

        pagamento.setJogador(jogador);
        Pagamento salvo = pagamentoRepository.save(pagamento);
        return new PagamentoComNomeDTO(salvo.getCod_pagamento(), salvo.getAno(), salvo.getMes(),
                salvo.getValor(), salvo.getJogador().getCodJogador(), salvo.getJogador().getNome());
    }

    public PagamentoComNomeDTO buscarPorId(Long id) {
        Pagamento pag = pagamentoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));
        return new PagamentoComNomeDTO(pag.getCod_pagamento(), pag.getAno(), pag.getMes(),
                pag.getValor(), pag.getJogador().getCodJogador(), pag.getJogador().getNome());
    }

    public void deletar(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado");
        }
        pagamentoRepository.deleteById(id);
    }
}