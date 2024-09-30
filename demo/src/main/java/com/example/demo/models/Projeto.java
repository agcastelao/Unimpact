package com.example.demo.models;

import org.hibernate.type.descriptor.java.LocalDateJavaType;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_projeto;

    private LocalDate iniciacao_projeto;

    // Relacionamento 1:1 com Proposta
    @OneToOne
    @JoinColumn(name = "id_proposta")
    private Proposta proposta;

    public Long getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Long id_projeto) {
        this.id_projeto = id_projeto;
    }

    public LocalDate getIniciacao_projeto() {
        return iniciacao_projeto;
    }

    public void setIniciacao_projeto(LocalDate iniciacao_projeto) {
        this.iniciacao_projeto = iniciacao_projeto;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

}
