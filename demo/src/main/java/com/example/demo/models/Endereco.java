package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    @OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;
    
    private String bairro;
    private String rua;
    private String num_residencia;
    private String complemento;
    private String estado_res;
    
    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }
    
    public void setUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getNum_residencia() {
        return num_residencia;
    }
    
    public void setNum_residencia(String num_residencia) {
        this.num_residencia = num_residencia;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getEstado_res() {
        return estado_res;
    }
    
    public void setEstado_res(String estado_res) {
        this.estado_res = estado_res;
    }

}
