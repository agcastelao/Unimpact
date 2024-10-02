package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposta;

    @ManyToMany(mappedBy = "propostas")
    private List<Usuario> usuarios;

    @OneToOne(mappedBy = "proposta")
    private Projeto projeto;
    
    private String status_proposta;
    
    


    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getId_proposta() {
        return id_proposta;
    }

    public void setId_proposta(Long id_proposta) {
        this.id_proposta = id_proposta;
    }

    public String getStatus_proposta() {
        return status_proposta;
    }

    public void setStatus_proposta(String status_proposta) {
        this.status_proposta = status_proposta;
    }

   

    
}

