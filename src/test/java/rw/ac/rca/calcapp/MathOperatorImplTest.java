package rw.ac.rca.calcapp;

import org.junit.jupiter.api.Test;
import rw.ac.rca.calcapp.services.MathOperator;
import rw.ac.rca.calcapp.servicesImpl.MathOperatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathOperatorImplTest {

    @Test
    void testDoMath_Addition() {
        MathOperator mathOperator = new MathOperatorImpl();
        double result = mathOperator.doMath(3, 5, "+");
        assertEquals(8, result, 0.0001);
    }

    @Test
    void testDoMath_Subtraction() {
        MathOperator mathOperator = new MathOperatorImpl();
        double result = mathOperator.doMath(10, 4, "-");
        assertEquals(6, result, 0.0001);
    }

    @Test
    void testDoMath_Multiplication() {
        MathOperator mathOperator = new MathOperatorImpl();
        double result = mathOperator.doMath(2, 6, "*");
        assertEquals(12, result, 0.0001);
    }

    @Test
    void testDoMath_DivisionByZero() {
        MathOperator mathOperator = new MathOperatorImpl();
        // Verify that an IllegalArgumentException is thrown for division by zero
        assertThrows(IllegalArgumentException.class, () -> mathOperator.doMath(5, 0, "/"));
    }

    @Test
    void testDoMath_InvalidOperation() {
        MathOperator mathOperator = new MathOperatorImpl();
        // Verify that an IllegalArgumentException is thrown for an invalid operation
        assertThrows(IllegalArgumentException.class, () -> mathOperator.doMath(2, 3, "%"));
    }


}