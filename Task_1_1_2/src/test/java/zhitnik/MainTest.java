package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**Тест.*/
public class MainTest {

    @Test
    void testPlus1() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{4, 5, 6});
        Assertions.assertEquals(
                p1.plus(p2), new Main(new int[]{5, 7, 9})
        );
    }

    @Test
    void testPlus2() {
        Main p1 = new Main(new int[]{0, 0, 0, 5});
        Main p2 = new Main(new int[]{3, -2, 1});
        Assertions.assertEquals(
                p1.plus(p2), new Main(new int[]{3, -2, 1, 5})
        );
    }

    @Test
    void testMinus() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{4, 5, 6});
        Assertions.assertEquals(
                p1.minus(p2), new Main(new int[]{-3, -3, -3})
        );
    }

    @Test
    void testTimes() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{4, 5});
        Assertions.assertEquals(
                p1.times(p2), new Main(new int[]{4, 13, 22, 15})
        );
    }

    @Test
    void generalTest() {
        Main.main(new String[]{});
        Assertions.assertTrue(true);
    }

    @Test
    void testEvaluate1() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.evaluate(5), 5 * 5 * 3 + 2 * 5 + 1);
    }

    @Test
    void testEvaluate2() {
        Main p1 = new Main(new int[]{0, 0, 0, 5});
        Assertions.assertEquals(
                p1.evaluate(4), 4 * 4 * 4 * 5
        );
    }

    @Test
    void testEvaluate3() {
        Main p1 = new Main(new int[]{});
        Assertions.assertEquals(
                p1.evaluate(5), 0
        );
    }

    @Test
    void testDifferentiate1() {
        Main p1 = new Main(new int[]{9, 29, 11});
        Assertions.assertEquals(
                p1.differentiate(0), p1);
    }

    @Test
    void testEquals1() {
        Main p1 = new Main(new int[]{29, 9, 11});
        Main p2 = new Main(new int[]{11, 9, 29});
        Assertions.assertNotEquals(p1, p2);
    }

    @Test
    void testEquals2() {
        Main p1 = new Main(new int[]{29, 9, 11});
        Main p2 = new Main(new int[]{});
        Assertions.assertNotEquals(p1, p2);
    }
}