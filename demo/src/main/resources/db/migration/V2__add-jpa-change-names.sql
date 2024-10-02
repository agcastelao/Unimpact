-- Criar a tabela endereco
CREATE TABLE endereco (
    id_endereco BIGINT PRIMARY KEY,
    bairro VARCHAR(100),
    rua VARCHAR(100),
    num_residencia VARCHAR(10),
    complemento VARCHAR(50),
    estado_res VARCHAR(50)
);

-- Adicionar colunas de relacionamento de ManyToOne/OneToOne para usuario e proposta
ALTER TABLE usuario
ADD COLUMN id_endereco BIGINT,
ADD COLUMN nome VARCHAR(100),
ADD COLUMN cargo cargo_enum,
ADD CONSTRAINT fk_endereco_usuario
FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);

-- Adicionar coluna de relacionamento 1:1 em proposta para projeto
ALTER TABLE proposta
ADD COLUMN id_projeto BIGINT;

-- Adicionar chave estrangeira para a tabela proposta referenciando projeto
ALTER TABLE proposta
ADD CONSTRAINT fk_projeto_proposta
FOREIGN KEY (id_projeto) REFERENCES projeto(id_projeto);
