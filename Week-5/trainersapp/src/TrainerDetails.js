import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { mockTrainers } from './TrainersMock';

const TrainerDetail = () => {
    const { id } = useParams();
    const trainer = mockTrainers.find(t => t.TrainerId.toString() === id);

    if (!trainer) {
        return <div>Trainer not found.</div>;
    }

    return (
        <div>
            <p><strong>Trainer ID:</strong> {trainer.TrainerId}</p>
            <p><strong>Name:</strong> {trainer.Name}</p>
            <p><strong>Email:</strong> {trainer.Email}</p>
            <p><strong>Phone:</strong> {trainer.Phone}</p>
            <p><strong>Technology:</strong> {trainer.Technology}</p>
            <p><strong>Skills:</strong> {trainer.Skills}</p>
            <br />
            <Link to="/trainers">Back to List</Link>
        </div>
    );
}

export default TrainerDetail;
