package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
    
}
