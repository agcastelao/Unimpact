package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Proposta;
import com.example.demo.repository.PropostaRepository;

@Service
public class PropostaService {
    @Autowired
    private PropostaRepository propostaRepository;

    public Proposta submeterProposta(Proposta proposta) {
        return propostaRepository.save(proposta);
    }
}

