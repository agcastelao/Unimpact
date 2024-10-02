ALTER TABLE projeto
ADD COLUMN titulo VARCHAR(155),
ADD COLUMN descricao VARCHAR(255),
ADD COLUMN id_curso BIGINT,
ADD COLUMN arquivo VARCHAR(255),
ADD CONSTRAINT fk_idcurso_projeto
FOREIGN KEY (id_curso) REFERENCES curso(id_curso);