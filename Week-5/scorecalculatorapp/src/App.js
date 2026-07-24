import React from 'react';
import './App.css';
import CalculateScore from './components/CalculateScore';

function App() {
  return (
    <div className="App" style={{ padding: '20px', textAlign: 'center' }}>
      <h1>Score Calculator Application</h1>
      <CalculateScore
        Name="John Doe"
        School="Greenwood High School"
        Total={430}
        goal={5}
      />
      <CalculateScore
        Name="Jane Smith"
        School="Springfield Academy"
        Total={385}
        goal={5}
      />
    </div>
  );
}

export default App;
