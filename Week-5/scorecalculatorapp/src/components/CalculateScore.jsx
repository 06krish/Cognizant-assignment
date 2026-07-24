import React from 'react';

const CalculateScore = ({ Name, School, Total, goal }) => {
    // Calculating the average score based on Total and goal
    // Treating `goal` as the denominator (e.g. number of subjects)
    const average = (Total / goal).toFixed(2);

    return (
        <div style={{ border: '1px solid #ddd', padding: '20px', margin: '15px auto', borderRadius: '8px', maxWidth: '500px', backgroundColor: '#f9f9f9', textAlign: 'left' }}>
            <h2 style={{ textAlign: 'center', color: '#333' }}>Student Score Details</h2>
            <p><strong>Name:</strong> {Name}</p>
            <p><strong>School:</strong> {School}</p>
            <p><strong>Total Scored:</strong> {Total}</p>
            <p><strong>Goal/Subjects:</strong> {goal}</p>
            <h3 style={{ color: '#2c3e50', borderTop: '1px solid #ddd', paddingTop: '10px' }}>Average Score: {average}</h3>
        </div>
    );
};

export default CalculateScore;
