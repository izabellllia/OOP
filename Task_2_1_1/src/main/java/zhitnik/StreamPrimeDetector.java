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
        return numbers.stream().anyMatch(this::isNonPrime);
    }

    /**
     * Метод, проверяющий является ли число непростым.
     */
    private boolean isNonPrime(int number) {
        if (number <= 1) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
