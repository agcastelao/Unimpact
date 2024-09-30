import React, { useState } from 'react';
import '../css/ProposalSubmission.css'; 
import 'bootstrap/dist/css/bootstrap.min.css'; 

const ProposalSubmission = () => {
  const [proposal, setProposal] = useState({
    title: '',
    description: '',
    course: ''
  });
  const [document, setDocument] = useState(null);
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(false);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProposal({ ...proposal, [name]: value });
  };

  const handleFileChange = (e) => {
    setDocument(e.target.files[0]);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setError(false);
    setSuccess(false);

    setTimeout(() => {
      setLoading(false);
      setSuccess(true);
      console.log('Proposta enviada:', proposal);
      console.log('Arquivo:', document);
    }, 2000); 
  };

  const handleReset = () => {
    setProposal({
      title: '',
      description: '',
      course: ''
    });
    setDocument(null);
    setError(false);
    setSuccess(false);
  };

  return (
    <div className="container mt-5">
      <header>
        <nav className="navbar navbar-expand-sm navbar-light">
          <div className="container">
            <a href="#" className="navbar-brand">
              <img src="/imagens/Logo_do_projeto_Unimpact.png" width="142" alt="Logo" />
            </a>
            <div className="collapse navbar-collapse" id="nav-topo">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                  <a href="/login" className="nav-link">
                    <button className="btn btn-roxo-c">
                      <img
                        src="/imagens/icon_usuario.png"
                        width="18"
                        alt="Ícone Usuário"
                        style={{ marginRight: '5px' }}
                      />
                      <span className="hover-text">PROFESSOR</span>
                    </button>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>

      <section className="caixa conteudo">
        <div className="container d-flex justify-content-center">
          <div className="card p-4 shadow-lg" style={{ width: '40rem' }}>
            <h4 className="text-center mb-4">Submissão de Propostas</h4>

            {success && <div className="alert alert-success">Proposta enviada com sucesso!</div>}
            {error && <div className="alert alert-danger">Por favor, preencha todos os campos obrigatórios.</div>}

            <form className="mt-4" onSubmit={handleSubmit} onReset={handleReset}>
              <div className="form-group">
                <label htmlFor="title">Título do Projeto</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  name="title"
                  value={proposal.title}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="description">Descrição</label>
                <textarea
                  className="form-control"
                  id="description"
                  name="description"
                  rows="4"
                  value={proposal.description}
                  onChange={handleInputChange}
                  required
                ></textarea>
              </div>

              <div className="form-group">
                <label htmlFor="course">Curso do Aluno</label>
                <input
                  type="text"
                  className="form-control"
                  id="course"
                  name="course"
                  value={proposal.course}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="document">Anexar Arquivo (Opcional)</label>
                <input
                  type="file"
                  className="form-control"
                  id="document"
                  name="document"
                  onChange={handleFileChange}
                />
              </div>

              <div className="btn-container">
                <button type="submit" className="btn btn-card" disabled={loading}>
                  {loading ? 'Enviando...' : 'Enviar Proposta'}
                </button>
                <button type="reset" className="btn btn-secondary">
                  Limpar Campos
                </button>
              </div>
            </form>
          </div>
        </div>
      </section>

      <footer id="footer_unicap" className="text-center mt-5">
        <a href="https://portal.unicap.br/">
          <img
            src="/imagens/footer_unicap.png"
            className="rounded mx-auto d-block img-fluid"
            width="900"
            alt="Footer Unicap"
          />
        </a>
      </footer>
    </div>
  );
};

export default ProposalSubmission;
