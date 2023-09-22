package zhitnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**Тест.*/
public class MainTest {

    @Test
    public void testPlus() {
        int[] coefficients1 = {1, 2, 3}; // x^2 + 2x + 3
        int[] coefficients2 = {4, 5, 6}; // 4x^2 + 5x + 6

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main sum = polynomial1.plus(polynomial2);

        int[] expectedCoefficients = {5, 7, 9}; // (x^2 + 2x + 3) + (4x^2 + 5x + 6) = 5x^2 + 7x + 9

        assertArrayEquals(expectedCoefficients, sum.getCoefficients());
    }

    @Test
    public void testMinus() {
        int[] coefficients1 = {1, 2, 3}; // x^2 + 2x + 3
        int[] coefficients2 = {4, 5, 6}; // 4x^2 + 5x + 6

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main difference = polynomial1.minus(polynomial2);

        int[] expectedCoefficients = {-3, -3, -3}; // (x^2 + 2x + 3) - (4x^2 + 5x + 6) = -3x^2 - 3x - 3

        assertArrayEquals(expectedCoefficients, difference.getCoefficients());
    }

    @Test
    public void testTimes() {
        int[] coefficients1 = {1, 2, 3}; // x^2 + 2x + 3
        int[] coefficients2 = {4, 5}; // 4x + 5

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main product = polynomial1.times(polynomial2);

        int[] expectedCoefficients = {4, 13, 22, 15}; // (x^2 + 2x + 3) * (4x + 5) = 4x^3 + 13x^2 + 22x + 15

        assertArrayEquals(expectedCoefficients, product.getCoefficients());
    }

    @Test
    public void testEvaluate() {
        int[] coefficients = {1, 2, 3}; // x^2 + 2x + 3

        Main polynomial = new Main(coefficients);

        int x = 2;
        int result = polynomial.evaluate(x);

        int expectedResult = 11; // (2^2) + (2*2) + 3 = 4 + 4 + 3 = 11

        assertEquals(expectedResult, result);
    }
}