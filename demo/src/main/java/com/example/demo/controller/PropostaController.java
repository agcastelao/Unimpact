package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Proposta;
import com.example.demo.service.PropostaService;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping("/submeter")
    public ResponseEntity<Proposta> submeterProposta(@RequestBody Proposta proposta) {
        Proposta novaProposta = propostaService.submeterProposta(proposta);
        return new ResponseEntity<>(novaProposta, HttpStatus.CREATED);
    }
}

