package zhitnik;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * some tests.
 */
public class ParallelPrimeDetectorTests {
    @Test
    public void testAllNumbersPrimeTrueResult() {
        List<Integer> nonPrimeNumbers = Arrays.asList(4, 6, 8, 9, 10);
        ParallelPrimeDetector primeDetector = new ParallelPrimeDetector(nonPrimeNumbers, 4);
        boolean result = primeDetector.hasNonPrimeNumbers(nonPrimeNumbers);
        Assertions.assertTrue(result);
    }

    @Test
    public void testAllNumbersPrimeFalseResult() {
        List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11);
        ParallelPrimeDetector primeDetector = new ParallelPrimeDetector(primeNumbers, 4);
        boolean result = primeDetector.hasNonPrimeNumbers(primeNumbers);
        Assertions.assertFalse(result);
    }

    @Test
    public void testAllNumbersPrimeTaskEx() {
        List<Integer> primeNumbers = Arrays.asList(6, 8, 7, 13, 5, 9);
        ParallelPrimeDetector primeDetector = new ParallelPrimeDetector(primeNumbers, 4);
        boolean result = primeDetector.hasNonPrimeNumbers(primeNumbers);
        Assertions.assertTrue(result);
    }

    @Test
    public void testAllNumbersPrime_WithNonPrimeNumbers() {
        List<Integer> nonPrimeNumbers = Arrays.asList(20319251, 6997901,
                6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053);
        ParallelPrimeDetector primeDetector = new ParallelPrimeDetector(nonPrimeNumbers, 4);
        boolean result = primeDetector.hasNonPrimeNumbers(nonPrimeNumbers);
        Assertions.assertFalse(result);
    }

}