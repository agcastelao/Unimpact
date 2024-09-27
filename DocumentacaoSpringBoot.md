# Spring Boot - Integração com Banco de Dados

Este documento explica como configurar uma aplicação **Spring Boot** para integrar-se a um banco de dados usando **Spring Data JPA**. Vamos construir uma aplicação simples para gerenciar clientes, que realiza operações de CRUD (Create, Read, Update, Delete) e se conecta a um banco de dados MySQL.

## Requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:

- JDK 11 ou superior
- IDE (como IntelliJ IDEA ou Eclipse)
- MySQL Server
- Maven (gerenciador de dependências)

## Etapas de Configuração

### 1. Criar o Projeto Spring Boot

Você pode criar o projeto manualmente ou usando o [Spring Initializr](https://start.spring.io/). Se optar por usar o Spring Initializr:

- Escolha o **Grupo** (groupId) e o **Artefato** (artifactId) para o projeto.
- Selecione as dependências:
  - **Spring Web** (para APIs REST)
  - **Spring Data JPA** (para integração com banco de dados)
  - **MySQL Driver** (para conectar ao MySQL)

Após isso, baixe o projeto e importe para sua IDE.

### 2. Configuração do `POM.xml`

No arquivo `pom.xml`, as dependências precisam estar definidas. Isso garante que todas as bibliotecas necessárias para o desenvolvimento com banco de dados estejam disponíveis.

 <!-- -->
<dependencies>
    <!-- Dependência para criar APIs REST -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Dependência para trabalhar com banco de dados via JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Dependência do driver MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>


Essas dependências garantem que você possa criar APIs RESTful, trabalhar com banco de dados via JPA e se conectar ao MySQL.

3. Configurar o Banco de Dados MySQL
Crie um banco de dados no MySQL chamado clientes_db (ou qualquer outro nome que preferir).

CREATE DATABASE clientes_db;

4. Configuração do application.properties
Agora, configure o arquivo application.properties para que o Spring Boot saiba como se conectar ao banco de dados MySQL.


# Configurações de conexão com o banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/clientes_db
spring.datasource.username=root
spring.datasource.password=sua_senha

# Configurações JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.datasource.url: O endereço JDBC para conectar ao banco MySQL.
spring.datasource.username: O nome de usuário do MySQL.
spring.datasource.password: A senha do usuário MySQL.
spring.jpa.hibernate.ddl-auto=update: Gera e atualiza automaticamente as tabelas no banco de dados.
spring.jpa.show-sql=true: Mostra as queries SQL no console para depuração.
5. Criar a Entidade Cliente
Uma entidade representa uma tabela no banco de dados. Vamos criar a classe Cliente para representar nossos clientes no banco.

Crie um pacote chamado models e dentro dele, a classe Cliente.java:

// começa ja daqui o código 

package com.exemplo.clientes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
  public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


@Entity: Informa ao JPA que esta classe representa uma tabela no banco.
@Id: Define o identificador único (chave primária).
@GeneratedValue: Define como o valor da chave será gerado automaticamente.
6. Criar o Repositório ClienteRepository
O repositório é a interface responsável por acessar o banco de dados e realizar operações de CRUD. Ele herda de JpaRepository.

Crie um pacote chamado repositories e dentro dele, crie a interface ClienteRepository.java:

package com.exemplo.clientes.repositories;

import com.exemplo.clientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Pode-se adicionar métodos personalizados, se necessário
}


Essa interface oferece métodos como save(), findAll(), findById(), e deleteById(), que já são implementados pelo Spring Data JPA.

7. Criar o Controlador ClienteController
O controlador expõe os endpoints da API REST para interagir com os dados de Cliente.

Crie um pacote chamado controllers e dentro dele, crie a classe ClienteController.java:

// começa já daqui o códogo

package com.exemplo.clientes.controllers;

import com.exemplo.clientes.models.Cliente;
import com.exemplo.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Adicionar um novo cliente
    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Atualizar um cliente existente
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        return clienteRepository.save(cliente);
    }

    // Deletar um cliente
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}


@RestController: Define que esta classe será um controlador REST.
@RequestMapping("/clientes"): Define o endpoint /clientes para acessar os recursos do cliente.
@Autowired: Injeta a dependência do ClienteRepository no controlador.
@GetMapping: Define o método HTTP GET para listar todos os clientes.
@PostMapping: Define o método HTTP POST para adicionar um novo cliente.
@PutMapping: Define o método HTTP PUT para atualizar um cliente existente.
@DeleteMapping: Define o método HTTP DELETE para remover um cliente.
8. Executar a Aplicação
Agora que todos os componentes estão configurados, você pode executar a aplicação. Para isso, vá até a classe principal da aplicação (geralmente Application.java) e rode o projeto.

Na sua IDE ou terminal, use o seguinte comando:

mvn spring-boot:run

Testar a API
Com a aplicação rodando, você pode testar os endpoints usando uma ferramenta como Postman ou o curl.

Listar todos os clientes (GET)

GET http://localhost:8080/clientes


Adicionar um novo cliente (POST)

POST http://localhost:8080/clientes
Content-Type: application/json

{
    "nome": "Maria Silva",
    "email": "maria@email.com"
}

Atualizar um cliente (PUT)

PUT http://localhost:8080/clientes/1
Content-Type: application/json

{
    "nome": "Maria Santos",
    "email": "maria.santos@email.com"
}

Deletar um cliente (DELETE)

DELETE http://localhost:8080/clientes/1

** uma aplicação Spring Boot conectada a um banco de dados MySQL, usando Spring Data JPA para realizar operações de CRUD

