package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Analisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos para um (N:1) com Usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Muitos para um (N:1) com Proposta
    @ManyToOne
    @JoinColumn(name = "id_proposta")
    private Proposta proposta;

    private LocalDate dataAnalise;

    private String obs;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Proposta getProposta() {
        return proposta;
    }
    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }
    public LocalDate getDataAnalise() {
        return dataAnalise;
    }
    public void setDataAnalise(LocalDate dataAnalise) {
        this.dataAnalise = dataAnalise;
    }
    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }

}
