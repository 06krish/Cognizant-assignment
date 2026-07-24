import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './Trainerlist';
import TrainerDetail from './TrainerDetails';
import { mockTrainers } from './TrainersMock';

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1 style={{ fontSize: '32px' }}>My Academy Trainers App</h1>
        <nav style={{ marginBottom: '20px' }}>
          <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={mockTrainers} />} />
          <Route path="/trainers/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
