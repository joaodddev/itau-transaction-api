package com.joaodddev.itau.service;

import com.joaodddev.itau.model.Estatistica;
import com.joaodddev.itau.model.Transacao;
import com.joaodddev.itau.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void adicionar(Transacao t) {

        if (t.getValor() < 0 || t.getDataHora() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (t.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        repository.salvar(t);
    }

    public void limpar() {
        repository.limpar();
    }

    public Estatistica calcular() {

        OffsetDateTime agora = OffsetDateTime.now();

        List<Transacao> ultimas = repository.listar().stream()
                .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(60)))
                .toList();

        DoubleSummaryStatistics stats = ultimas.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            return new Estatistica(0, 0, 0, 0, 0);
        }

        return new Estatistica(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax());
    }
}