public class AtualizarStatus {
    private int id;
    private String titulo;
    private String descricao;
    private StatusAtualizarStatus status;
    private String alunoSolicitante;
    private String faculdade;
    private String coordenador;
    private String professor;

    // Construtor, getters e setters

    public AtualizarStatus(int id, String titulo, String descricao, String alunoSolicitante) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.alunoSolicitante = alunoSolicitante;
        this.status = StatusProposta.ENVIADA;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public void setStatus(StatusProposta status) {
        this.status = status;
    }

    public String getAlunoSolicitante() {
        return alunoSolicitante;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    // Mais getters e setters...
}