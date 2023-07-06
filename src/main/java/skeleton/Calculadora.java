package skeleton;

/**
 * The Calculadora class represents a simple calculator that can perform
 * addition operations.
 * 
 * This class provides a method to add two integers and return the result.
 * 
 * Example usage:
 * 
 * Calculadora calculadora = new Calculadora(); int result =
 * calculadora.somar(5, 3);
 * System.out.println(result); // Output: 8
 */

public class Calculadora {

    /**
     * Adds two integers and returns the result.
     * 
     * @param num1 The first integer to be added.
     * @param num2 The second integer to be added.
     * @return The sum of the two integers.
     */
    public int addNumbers(final int num1, final int num2) {
        return num1 + num2;
    }
}
