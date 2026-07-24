import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = (props) => {
    // 10. Define the style for <h3> element to use "green" color font when cohort status is "ongoing" and "blue" color in all other scenarios.
    // Note: Checking for 'ongoing' (case insensitive) just in case
    const isOngoing = props.status && props.status.toLowerCase() === 'ongoing';
    const titleStyle = {
        color: isOngoing ? 'green' : 'blue'
    };

    return (
        <div className={styles.box}>
            <h3 style={titleStyle}>{props.title}</h3>
            <dl>
                <dt>Started On</dt>
                <dd>{props.startedOn}</dd>

                <dt>Current Status</dt>
                <dd>{props.status}</dd>

                <dt>Coach</dt>
                <dd>{props.coach}</dd>

                <dt>Trainer</dt>
                <dd>{props.trainer}</dd>
            </dl>
        </div>
    );
};

export default CohortDetails;
