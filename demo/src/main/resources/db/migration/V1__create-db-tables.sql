CREATE TYPE cargo_enum AS ENUM ('ADMIN', 'COORDENADOR', 'PROFESSOR', 'USUARIO');

CREATE TABLE Usuario (
    id_usuario BIGINT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL, 
    telefone1 VARCHAR(17) NOT NULL,
    telefone2 VARCHAR(17),
    cnpj VARCHAR(20),             
    cpf VARCHAR(20) NOT NULL
);

-- Tabela de propostas
CREATE TABLE Proposta (
    id_proposta BIGINT PRIMARY KEY,
    status_proposta VARCHAR(50) NOT NULL 
);

-- Tabela de projetos
CREATE TABLE Projeto (
    id_projeto BIGINT PRIMARY KEY,
    iniciacao_projeto BOOLEAN NOT NULL,
    id_proposta BIGINT, 
    CONSTRAINT fk_proposta_id_proposta FOREIGN KEY (id_proposta)
    REFERENCES Proposta(id_proposta)
);

-- Tabela de contrapropostas
CREATE TABLE Contraproposta_Analisa (
    id_proposta BIGINT, 
    id_usuario BIGINT,    
    PRIMARY KEY (id_proposta, id_usuario), 
    CONSTRAINT fk_proposta_id_proposta FOREIGN KEY (id_proposta)
    REFERENCES Proposta(id_proposta),
    CONSTRAINT fk_usuario_id_usuario FOREIGN KEY (id_usuario)
    REFERENCES Usuario(id_usuario)
);
