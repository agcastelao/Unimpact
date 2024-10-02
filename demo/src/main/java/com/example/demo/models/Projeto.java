package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_projeto;

    private String titulo;

    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    private String arquivo;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    
}
