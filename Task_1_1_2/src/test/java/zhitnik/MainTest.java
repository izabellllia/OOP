package zhitnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



/**Тест.*/
public class MainTest {

    @Test
    public void testPlus() {
        int[] coefficients1 = {1, 2, 3};
        int[] coefficients2 = {4, 5, 6};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main sum = polynomial1.plus(polynomial2);

        int[] expectedCoefficients = {5, 7, 9};
        Main expectedSum = new Main(expectedCoefficients);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testMinus() {
        int[] coefficients1 = {1, 2, 3};
        int[] coefficients2 = {4, 5, 6};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main difference = polynomial1.minus(polynomial2);

        int[] expectedCoefficients = {-3, -3, -3};
        Main expectedDifference = new Main(expectedCoefficients);

        assertEquals(expectedDifference, difference);
    }

    @Test
    public void testTimes() {
        int[] coefficients1 = {1, 2, 3};
        int[] coefficients2 = {4, 5, 6};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);

        Main product = polynomial1.times(polynomial2);

        int[] expectedCoefficients = {4, 13, 28, 27, 18};
        Main expectedProduct = new Main(expectedCoefficients);

        assertEquals(expectedProduct, product);
    }

    @Test
    public void testEvaluate() {
        int[] coefficients = {1, 2, 3};

        Main polynomial = new Main(coefficients);

        double x = 2.0;
        double result = polynomial.evaluate(x);

        double expectedValue = 17.0;

        assertEquals(expectedValue, result, 0.0001);
    }
}
