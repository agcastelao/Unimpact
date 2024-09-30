package com.example.demo.modelos;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proposta;

    private String status_proposta;

   
    public int getId_proposta() {
        return id_proposta;
    }

    public void setId_proposta(int id_proposta) {
        this.id_proposta = id_proposta;
    }

    public String getStatus_proposta() {
        return status_proposta;
    }

    public void setStatus_proposta(String status_proposta) {
        this.status_proposta = status_proposta;
    }

   

    
}

