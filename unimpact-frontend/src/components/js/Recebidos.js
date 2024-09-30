import React, { useState } from 'react';
import '../css/Recebidos.css'; // Estilização da lista de propostas recebidas
import { Modal, Button } from 'react-bootstrap'; // Importa componentes para modal

const PropostasRecebidas = () => {
  const [propostas, setPropostas] = useState([
    { id: 1, titulo: 'Proposta 1', curso: 'Engenharia', status: 'Pendente' },
    { id: 2, titulo: 'Proposta 2', curso: 'Administração', status: 'Pendente' },
    { id: 3, titulo: 'Proposta 3', curso: 'Direito', status: 'Pendente' },
  ]);
  const [showModal, setShowModal] = useState(false);
  const [selectedProposal, setSelectedProposal] = useState(null);
  const [comment, setComment] = useState('');
  const [filter, setFilter] = useState('');

  // Função para aprovar uma proposta
  const handleApprove = (id) => {
    setPropostas(propostas.map((p) =>
      p.id === id ? { ...p, status: 'Aprovado' } : p
    ));
    setShowModal(false);
  };

  // Função para rejeitar uma proposta
  const handleReject = (id) => {
    setPropostas(propostas.map((p) =>
      p.id === id ? { ...p, status: 'Rejeitado' } : p
    ));
    setShowModal(false);
  };

  // Função para filtrar propostas
  const filteredPropostas = propostas.filter((p) =>
    p.curso.toLowerCase().includes(filter.toLowerCase()) ||
    p.status.toLowerCase().includes(filter.toLowerCase())
  );

  // Função para abrir o modal com a proposta selecionada
  const handleOpenModal = (proposta) => {
    setSelectedProposal(proposta);
    setShowModal(true);
  };

  // Função para fechar o modal
  const handleCloseModal = () => {
    setShowModal(false);
    setComment('');
  };

  return (
    <div className="propostas-container">
      <header>
        <nav className="navbar navbar-expand-sm navbar-light">
          <div className="container">
            <a href="#" className="navbar-brand logo">
              <img src="/imagens/Logo_do_projeto_Unimpact.png" width="142" alt="Logo" />
            </a>
            <div className="admin-text">
              <img src="/imagens/icon_usuario.png" width="24" alt="Ícone Usuário" />
              <span>ADMINISTRADOR</span>
            </div>
          </div>
        </nav>
      </header>

      <section className="caixa conteudo">
        {/* Filtros e Pesquisa */}
        <input
          type="text"
          placeholder=" Filtrar por curso"
          value={filter}
          onChange={(e) => setFilter(e.target.value)}
          className="filter-bar"
        />

        <div className="container d-flex justify-content-center">
          <div className="card p-4 shadow-lg" style={{ width: '40rem' }}>
            <h4 className="text-center mb-4">Propostas Recebidas</h4>
            <table className="table table-striped mt-4">
              <thead>
                <tr>
                  <th>Título</th>
                  <th>Curso</th>
                  <th>Status</th>
                  <th>Ações</th>
                </tr>
              </thead>
              <tbody>
                {filteredPropostas.map((proposta) => (
                  <tr key={proposta.id}>
                    <td>{proposta.titulo}</td>
                    <td>{proposta.curso}</td>
                    <td>{proposta.status}</td>
                    <td>
                      <button
                        className="btn btn-approve btn-sm mr-2"
                        onClick={() => handleOpenModal(proposta)}
                      >
                        Aprovar
                      </button>
                      <button
                        className="btn btn-reject btn-sm"
                        onClick={() => handleOpenModal(proposta)}
                      >
                        Rejeitar
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </section>

      {/* Modal de Aprovação/Rejeição */}
      <Modal show={showModal} onHide={handleCloseModal}>
        <Modal.Header closeButton>
          <Modal.Title>Tomar Ação</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>Adicionar comentário para {selectedProposal?.titulo}</p>
          <textarea
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            rows="3"
            className="form-control"
          />
        </Modal.Body>
        <Modal.Footer>
          <Button variant="success" onClick={() => handleApprove(selectedProposal?.id)}>
            Aprovar
          </Button>
          <Button variant="danger" onClick={() => handleReject(selectedProposal?.id)}>
            Rejeitar
          </Button>
        </Modal.Footer>
      </Modal>

      <footer id="footer_unicap">
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

export default PropostasRecebidas;
