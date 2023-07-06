package skeleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    Calculadora calculadora;

    @Test
    void testAddNumbers() {
        // Testing for adding two positive numbers
        int result1 = this.calculadora.addNumbers(3, 4);
        assertEquals(7, result1);

        // Testing for adding a positive number and zero
        int result2 = this.calculadora.addNumbers(5, 0);
        assertEquals(5, result2);

        // Testing for adding a positive number and a negative number
        int result3 = this.calculadora.addNumbers(10, -5);
        assertEquals(5, result3);

        // Testing for adding two negative numbers
        int result4 = this.calculadora.addNumbers(-2, -3);
        assertEquals(-5, result4);
    }
}
