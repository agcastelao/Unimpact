public class NotificacaoService {

    public void notificarCoordenador(String coordenador, String mensagem) {
        System.out.println("Notificação para o Coordenador " + coordenador + ": " + mensagem);
    }

    public void notificarProfessor(String professor, String mensagem) {
        System.out.println("Notificação para o Professor " + professor + ": " + mensagem);
    }

    public void notificarAluno(String aluno, String mensagem) {
        System.out.println("Notificação para o Aluno " + aluno + ": " + mensagem);
    }
}
