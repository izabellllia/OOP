package zhitnik;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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

        int[] expectedCoefficients = {5, 7, 9};

        assertArrayEquals(expectedCoefficients, sum.getCoefficients());
    }

    /**minus.*/
    @Test
    public void testMinus() {
        int[] coefficients1 = {1, 2, 3}; // x^2 + 2x + 3
        int[] coefficients2 = {4, 5, 6}; // 4x^2 + 5x + 6

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main difference = polynomial1.minus(polynomial2);

        int[] expectedCoefficients = {-3, -3, -3};

        assertArrayEquals(expectedCoefficients, difference.getCoefficients());
    }

    /**times.*/
    @Test
    public void testTimes() {
        int[] coefficients1 = {1, 2, 3}; // x^2 + 2x + 3
        int[] coefficients2 = {4, 5}; // 4x + 5

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main product = polynomial1.times(polynomial2);

        int[] expectedCoefficients = {4, 13, 22, 15};

        assertArrayEquals(expectedCoefficients, product.getCoefficients());
    }

    @Test
    public void testPlus2() {
        int[] coefficients1 = {2, 3, 4}; // 2x^2 + 3x + 4
        int[] coefficients2 = {5, 6, 7}; // 5x^2 + 6x + 7

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main sum = polynomial1.plus(polynomial2);

        int[] expectedCoefficients = {7, 9, 11};

        assertArrayEquals(expectedCoefficients, sum.getCoefficients());
    }

    @Test
    public void testMinus2() {
        int[] coefficients1 = {2, 3, 4}; // 2x^2 + 3x + 4
        int[] coefficients2 = {5, 6, 7}; // 5x^2 + 6x + 7

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main difference = polynomial1.minus(polynomial2);

        int[] expectedCoefficients = {-3, -3, -3};

        assertArrayEquals(expectedCoefficients, difference.getCoefficients());
    }

    @Test
    public void testTimes2() {
        int[] coefficients1 = {2, 3, 4}; // 2x^2 + 3x + 4
        int[] coefficients2 = {5, 6}; // 5x + 6

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main product = polynomial1.times(polynomial2);

        int[] expectedCoefficients = {10, 27, 38, 24};

        assertArrayEquals(expectedCoefficients, product.getCoefficients());
    }

}