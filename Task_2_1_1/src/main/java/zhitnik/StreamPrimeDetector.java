package zhitnik;

import java.util.List;

/**
 * Класс, который использует потоки для поиска непростых чисел.
 */
public class StreamPrimeDetector {
    private final List<Integer> numbers;

    public StreamPrimeDetector(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNonPrimeNumbers() {
        return numbers.stream().anyMatch(number -> !IsPrime.PrimeMethod(number));
    }
}
