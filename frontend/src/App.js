import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Usando Routes no lugar de Switch
import ProposalSubmission from './components/js/ProposalSubmission';  // Componente principal
import Recebidos from './unimpact/components/js/Recebidos'; 
  // Componente Recebidos
import './App.css';

function App() {
  return (
    <Router>
      <Routes>
        {/* Rota para o componente ProposalSubmission */}
        <Route path="/" element={<ProposalSubmission />} />

        {/* Rota para o componente Recebidos */}
        <Route path="/recebidos" element={<Recebidos />} />
      </Routes>
    </Router>
  );
}

export default App;
