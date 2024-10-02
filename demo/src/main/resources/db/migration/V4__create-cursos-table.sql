CREATE TABLE curso (
    id_curso BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL    
);

CREATE TABLE assoc_curso_usuario (
    id_curso BIGINT, 
    id_usuario BIGINT,    
    PRIMARY KEY (id_curso, id_usuario), 
    CONSTRAINT fk_proposta_id_curso FOREIGN KEY (id_curso)
    REFERENCES curso(id_curso),
    CONSTRAINT fk_usuario_id_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
);