package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**Тест.*/
public class PolinomTest {

    @Test
    void testPlusSimple() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Polinom p2 = new Polinom(new int[]{5, 6, 7});
        Assertions.assertEquals(
                p1.plus(p2), new Polinom(new int[]{6, 8, 10})
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
    void testMinusSimple() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Polinom p2 = new Polinom(new int[]{4, 5, 6});
        Assertions.assertEquals(
                p1.minus(p2), new Polinom(new int[]{-3, -3, -3})
        );
    }

    @Test
    void testMinusZero() {
        Polinom p1 = new Polinom(new int[]{0, 0, 0, 11});
        Polinom p2 = new Polinom(new int[]{9, -1, 1});
        Assertions.assertEquals(
                p1.minus(p2), new Polinom(new int[]{-9, 1, -1, 11})
        );
    }

    @Test
    void testMinusSame() {
        Polinom p1 = new Polinom(new int[]{9, 29, 9});
        Polinom p2 = new Polinom(new int[]{9, 29, 9});
        Assertions.assertEquals(
                p1.minus(p2), new Polinom(new int[]{0, 0, 0})
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
    void testTimesZero() {
        Polinom p1 = new Polinom(new int[]{0, 0, 0, 5});
        Polinom p2 = new Polinom(new int[]{3, -2, 1});
        Assertions.assertEquals(
                p1.times(p2), new Polinom(new int[]{0, 0, 0, 15, -10, 5})
        );
    }

    @Test
    void testEvaluateSimple() {
        Polinom p1 = new Polinom(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.evaluate(5), 5 * 5 * 3 + 2 * 5 + 1);
    }

    @Test
    void testEvaluateZero() {
        Polinom p1 = new Polinom(new int[]{0, 0, 0, 5});
        Assertions.assertEquals(
                p1.evaluate(4), 4 * 4 * 4 * 5
        );
    }

    @Test
    void testDifferentiate() {
        Polinom p1 = new Polinom(new int[]{9, 29, 11});
        Assertions.assertEquals(
                p1.differentiate(0), p1);
    }

    @Test
    void testDifferentiateHigh() {
        Polinom p1 = new Polinom(new int[]{7, 6, 5, 4, 3, 2, 1});
        Assertions.assertEquals(
                p1.differentiate(5), new Polinom(new int[]{240, 720})
        );
    }

    @Test
    void testIsEqualsSimple() {
        Polinom p1 = new Polinom(new int[]{29, 9, 11});
        Polinom p2 = new Polinom(new int[]{29, 9, 11});
        Assertions.assertEquals(p1, p2);
    }

    @Test
    void testNotEqualsSimple() {
        Polinom p1 = new Polinom(new int[]{29, 9, 11});
        Polinom p2 = new Polinom(new int[]{11, 9, 29});
        Assertions.assertNotEquals(p1, p2);
    }

    @Test
    void testEqualsBoth() {
        Polinom p1 = new Polinom(new int[]{});
        Polinom p2 = new Polinom(new int[]{});
        Assertions.assertEquals(p1, p2);
    }

    @Test
    void stringTestSimple() {
        Polinom p1 = new Polinom(new int[]{2, 0, -3, 1});
        Assertions.assertEquals(
                p1.toString(), "1x^3 + -3x^2 + 2"
        );
    }

}