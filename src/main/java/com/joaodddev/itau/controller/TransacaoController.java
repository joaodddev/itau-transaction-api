package com.joaodddev.itau.controller;

import com.joaodddev.itau.model.Estatistica;
import com.joaodddev.itau.model.Transacao;
import com.joaodddev.itau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody Transacao t) {
        service.adicionar(t);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limpar() {
        service.limpar();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Estatistica> estatistica() {
        return ResponseEntity.ok(service.calcular());
    }
}