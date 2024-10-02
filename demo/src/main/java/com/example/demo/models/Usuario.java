package com.example.demo.models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

import com.example.demo.enum1.CargoEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    // Relacionamento com a entidade Proposta (1:N)
    @ManyToMany
    @JoinTable(
        name = "contraproposta_analisa",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_proposta")
    )
    private List<Proposta> propostas;
    
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(mappedBy = "usuarios")
    private List<Curso> cursos;

    private String cpf;
    private String nome;
    private String senha;
    private String email;
    private String telefone1;
    private String telefone2;

    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public CargoEnum getCargo() {
        return cargo;
    }
    
    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone_1() {
        return telefone1;
    }
    
    public void setTelefone_1(String telefone1) {
        this.telefone1 = telefone1;
    }
    
    public String getTelefone_2() {
        return telefone2;
    }
    
    public void setTelefone_2(String telefone2) {
        this.telefone2 = telefone2;
    }
    
    public List<Proposta> getPropostas() {
        return propostas;
    }
    
    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    
}


