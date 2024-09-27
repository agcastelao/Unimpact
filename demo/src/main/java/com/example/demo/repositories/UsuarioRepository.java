package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

    

