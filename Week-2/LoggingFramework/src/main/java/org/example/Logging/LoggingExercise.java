package org.example.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExercise {

    // Instantiate the logger using the correct public SLF4J API
    private static final Logger logger = LoggerFactory.getLogger(LoggingExercise.class);

    public static void main(String[] args) {
        logger.info("Application initialized. Starting logging exercise...");

        // 1. Simulating a Warning Level Scenario
        int availableMemoryMB = 150;
        if (availableMemoryMB < 200) {
            // Use .warn() for non-breaking, cautionary events
            logger.warn("System memory is running low! Remaining: {}MB", availableMemoryMB);
        }

        // 2. Simulating an Error Level Scenario
        try {
            logger.info("Attempting to process a critical file transaction...");
            simulateFaultyOperation();
        } catch (Exception e) {
            // Use .error() to record severe failures.
            // Passing the exception object 'e' as the last parameter prints the entire stack trace automatically.
            logger.error("A critical operation failure occurred during processing!", e);
        }

        logger.info("Logging exercise complete.");
    }

    private static void simulateFaultyOperation() throws Exception {
        throw new Exception("Database connection timeout or file not found.");
    }
}