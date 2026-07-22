package org.example.JUnitExercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertNotEquals(10, calculator.subtract(8, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void testPositive() {
        assertTrue(calculator.isPositive(10));
    }

    @Test
    void testNegative() {
        assertFalse(calculator.isPositive(-5));
    }

    @Test
    void testName() {
        assertNotNull(calculator.getName());
    }

    @Test
    void testMessage() {
        assertNull(calculator.getMessage());
    }

    @Test
    void testDivideByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @Test
    void testAllAssertions() {
        assertAll(
                () -> assertEquals(10, calculator.add(5, 5)),
                () -> assertEquals(5, calculator.subtract(10, 5)),
                () -> assertEquals(12, calculator.multiply(3, 4)),
                () -> assertTrue(calculator.isPositive(15)),
                () -> assertNotNull(calculator.getName())
        );
    }
}