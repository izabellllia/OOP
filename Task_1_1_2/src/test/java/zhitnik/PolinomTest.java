package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**Тест.*/
public class PolinomTest {

    @Test
    void testMainRunning() {
        Polinom.main(new String[]{});
        Assertions.assertTrue(true);
    }

    @Test
    void testPlusSimple() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Polinom p2 = new Polinom(new int[]{4, 5, 6});
        Assertions.assertEquals(
                p1.plus(p2), new Polinom(new int[]{5, 7, 9})
        );
    }

    @Test
    void testPlusNegative() {
        Polinom p1 = new Polinom(new int[]{0, 0, 0, 5});
        Polinom p2 = new Polinom(new int[]{3, -2, 1});
        Assertions.assertEquals(
                p1.plus(p2), new Polinom(new int[]{3, -2, 1, 5})
        );
    }

    @Test
    void testMinus() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Polinom p2 = new Polinom(new int[]{4, 5, 6});
        Assertions.assertEquals(
                p1.minus(p2), new Polinom(new int[]{-3, -3, -3})
        );
    }

    @Test
    void testTimes() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Polinom p2 = new Polinom(new int[]{4, 5});
        Assertions.assertEquals(
                p1.times(p2), new Polinom(new int[]{4, 13, 22, 15})
        );
    }

    @Test
    void testEvaluate1() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.evaluate(5), 5 * 5 * 3 + 2 * 5 + 1);
    }

    @Test
    void testEvaluate2() {
        Polinom p1 = new Polinom(new int[]{0, 0, 0, 5});
        Assertions.assertEquals(
                p1.evaluate(4), 4 * 4 * 4 * 5
        );
    }

    @Test
    void testEvaluate3() {
        Polinom p1 = new Polinom(new int[]{});
        Assertions.assertEquals(
                p1.evaluate(5), 0
        );
    }

    @Test
    void testDifferentiate1() {
        Polinom p1 = new Polinom(new int[]{9, 29, 11});
        Assertions.assertEquals(
                p1.differentiate(0), p1);
    }

    @Test
    void testEquals1() {
        Polinom p1 = new Polinom(new int[]{29, 9, 11});
        Polinom p2 = new Polinom(new int[]{11, 9, 29});
        Assertions.assertNotEquals(p1, p2);
    }

    @Test
    void testEquals2() {
        Polinom p1 = new Polinom(new int[]{29, 9, 11});
        Polinom p2 = new Polinom(new int[]{});
        Assertions.assertNotEquals(p1, p2);
    }
}