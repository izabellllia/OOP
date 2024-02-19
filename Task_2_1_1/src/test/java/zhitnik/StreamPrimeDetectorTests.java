package zhitnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * some tests.
 */
public class StreamPrimeDetectorTests {
    @Test
    void testAllNumbersPrimeTaskEx() {
        ArrayList<Integer> testList =
                new ArrayList<>(Arrays.asList(6, 8, 7, 13, 5, 9));
        StreamPrimeDetector test = new StreamPrimeDetector(testList);
        Assertions.assertTrue(test.hasNonPrimeNumbers());
    }

    @Test
    void testAllNumbersPrime_WithNonPrimeNumbers() {
        ArrayList<Integer> testList =
                new ArrayList<>(Arrays.asList(20319251, 6997901,
                        6997927, 6997937, 17858849, 6997967,
                        6998009, 6998029, 6998039, 20165149, 6998051, 6998053));
        StreamPrimeDetector test = new StreamPrimeDetector(testList);
        Assertions.assertFalse(test.hasNonPrimeNumbers());
    }
}