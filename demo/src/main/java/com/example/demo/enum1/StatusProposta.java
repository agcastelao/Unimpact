public enum StatusProposta {
    ENVIADA, // Enviada pelo aluno
    ACEITA_PELA_FACULDADE, // Aceita pela faculdade e enviada ao coordenador
    ENVIADA_AO_COORDENADOR, // Encaminhada ao coordenador
    ENVIADA_AO_PROFESSOR, // Coordenador enviou ao professor
    ACEITA_PELO_PROFESSOR, // Aceita pelo professor
    CONTRA_PROPOSTA, // Contra-proposta do professor
    ACEITA_PELO_ALUNO, // Contra-proposta aceita pelo aluno
    PROJETO_DE_EXTENSAO // Proposta se tornou um projeto de extensão
}