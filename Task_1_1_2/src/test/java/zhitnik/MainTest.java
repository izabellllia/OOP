package zhitnik;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Assertions;
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

    /**plus2.*/
    @Test
    public void testPlus2() {
        int[] coefficients1 = {0, 0, 0, 5};
        int[] coefficients2 = {3, -2, 1};

        Main polynomial1 = new Main(coefficients1);
        Main polynomial2 = new Main(coefficients2);
        Main sum = polynomial1.plus(polynomial2);

        int[] expectedCoefficients = {3, -2, 1, 5};

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
    void test1() {
        Main.main(new String[]{});
        Assertions.assertTrue(true);
    }

    @Test
    void test2() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.evaluate(5), 5 * 5 * 3 + 2 * 5 + 1);
    }

    @Test
    void test3() {
        Main p1 = new Main(new int[]{0, 0, 0, 5});
        Assertions.assertEquals(
                p1.evaluate(4), 4 * 4 * 4 * 5
        );
    }

    @Test
    void test4() {
        Main p1 = new Main(new int[]{});
        Assertions.assertEquals(
                p1.evaluate(5), 0
        );
    }

    @Test
    void test5() {
        Main p1 = new Main(new int[]{9, 29, 11});
        Assertions.assertEquals(
                p1.differentiate(0), p1);
    }

    @Test
    void test6() {
        Main p1 = new Main(new int[]{29, 9, 11});
        Main p2 = new Main(new int[]{11, 9, 29});
        Assertions.assertNotEquals(p1, p2);
    }

    @Test
    void test7() {
        Main p1 = new Main(new int[]{29, 9, 11});
        Main p2 = new Main(new int[]{});
        Assertions.assertNotEquals(p1, p2);
    }
}