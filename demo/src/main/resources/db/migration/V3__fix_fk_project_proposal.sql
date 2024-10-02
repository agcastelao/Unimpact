-- V3__fix_fk_project_proposal.sql

-- Remover a chave estrangeira id_projeto da tabela proposta
ALTER TABLE proposta
DROP CONSTRAINT IF EXISTS fk_proposta_projeto, 
DROP COLUMN IF EXISTS id_projeto;
