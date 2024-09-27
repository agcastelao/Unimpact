package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {
    
}

