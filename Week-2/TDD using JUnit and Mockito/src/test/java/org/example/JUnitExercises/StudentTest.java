package org.example.JUnitExercises;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student student;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Student Test Started");
    }

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void testName() {
        assertEquals("Krish", student.getName());
    }

    @Test
    void testEligibility() {
        assertTrue(student.isEligible());
    }

    @AfterEach
    void tearDown() {
        System.out.println("One Test Finished");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Student Test Finished");
    }
}