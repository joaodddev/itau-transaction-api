package com.joaodddev.itau.repository;

import com.joaodddev.itau.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class TransacaoRepository {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();

    public void salvar(Transacao t) {
        transacoes.add(t);
    }

    public List<Transacao> listar() {
        return transacoes;
    }

    public void limpar() {
        transacoes.clear();
    }
}