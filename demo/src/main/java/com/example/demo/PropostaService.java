import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {
    @Autowired
    private PropostaRepository propostaRepository;

    public Proposta submeterProposta(Proposta proposta) {
        return propostaRepository.save(proposta);
    }
}

