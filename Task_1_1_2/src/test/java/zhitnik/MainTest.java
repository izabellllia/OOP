package zhitnik;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testPlusWithDifferentLengths() {

        int[] coefficients1 = {2, 4, 6};
        int[] coefficients2 = {8, 10};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main result = polynomial1.plus(polynomial2);

        int[] expectedCoefficients = {10, 14, 6};

        Main expected = new Main(expectedCoefficients);

        assertTrue(result.equals(expected));
    }

    @Test
    public void testMinusWithNegativeCoefficients() {
        int[] coefficients1 = {2, -4, 6};
        int[] coefficients2 = {8, -10, 12};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main result = polynomial1.minus(polynomial2);

        int[] expectedCoefficients = {-6, 6, -6};

        Main expected = new Main(expectedCoefficients);

        assertTrue(result.equals(expected));
    }

    @Test
    public void testEqualsWithDifferentCoefficients() {
        int[] coefficients1 = {2, 4, 6};
        int[] coefficients2 = {8, 10, 12};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        assertFalse(polynomial1.equals(polynomial2));
    }

}