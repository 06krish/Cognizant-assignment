import React from 'react';
import './App.css';
import Posts from './Posts';

function App() {
  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Latest Posts</h1>
      <Posts />
    </div>
  );
}

export default App;
