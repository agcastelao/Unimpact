package com.example.demo.model;

import com.example.demo.enum1.CargoEnum;

public class User {
    
    private Long id;
    private String password;
    private String email;
    private String phone1;
    private String phone2;
    private String cnpj;
    private String cpf;
    private CargoEnum cargo;

    public User() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone1() {
        return phone1;
    }
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public CargoEnum getCargo() {
        return cargo;
    }
    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

}
