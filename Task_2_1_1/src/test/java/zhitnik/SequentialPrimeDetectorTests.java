package zhitnik;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * some tests.
 */
public class SequentialPrimeDetectorTests {
    @Test
    public void testAllNumbersPrimeTrueResult() {
        List<Integer> nonPrimeNumbers = Arrays.asList(4, 6, 8, 9, 10);
        PrimeDetector detector = new SequentialPrimeDetector(nonPrimeNumbers);
        boolean result = detector.hasNonPrimeNumbers();
        assertTrue(result);
    }

    @Test
    public void testAllNumbersPrimeFalseResult() {
        List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11);
        PrimeDetector detector = new SequentialPrimeDetector(primeNumbers);
        boolean result = detector.hasNonPrimeNumbers();
        assertFalse(result);
    }

    @Test
    public void testAllNumbersPrimeTaskEx() {
        List<Integer> primeNumbers = Arrays.asList(6, 8, 7, 13, 5, 9);
        PrimeDetector detector = new SequentialPrimeDetector(primeNumbers);
        boolean result = detector.hasNonPrimeNumbers();
        assertTrue(result);
    }

    @Test
    public void testAllNumbersPrime_WithNonPrimeNumbers_ReturnsFalse() {
        List<Integer> nonPrimeNumbers = Arrays.asList(20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053);
        PrimeDetector detector = new SequentialPrimeDetector(nonPrimeNumbers);
        boolean result = detector.hasNonPrimeNumbers();
        assertFalse(result);
    }
}