package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**Тест.*/
public class MainTest {

    @Test
    void testMainRunning() {
        Main.main(new String[]{});
        Assertions.assertTrue(true);
    }
    @Test
    void simpleEval() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.evaluate(5), 5 * 5 * 3 + 2 * 5 + 1);
    }

    @Test
    void lowerZerosEval() {
        Main p1 = new Main(new int[]{0, 0, 0, 5});
        Assertions.assertEquals(
                p1.evaluate(4), 4 * 4 * 4 * 5
        );
    }

    @Test
    void voidEval() {
        Main p1 = new Main(new int[]{});
        Assertions.assertEquals(
                p1.evaluate(5), 0
        );
    }


    @Test
    void nonDiff() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Assertions.assertEquals(
                p1.differentiate(0), p1
        );
    }

    @Test
    void simpleNotEqual() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{3, 2, 1});
        Assertions.assertNotEquals(p1, p2);
    }


    @Test
    void voidSecond() {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{});
        Assertions.assertNotEquals(p1, p2);
    }

}