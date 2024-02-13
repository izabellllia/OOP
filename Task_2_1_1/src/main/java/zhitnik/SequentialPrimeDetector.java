package zhitnik;

import java.util.List;

/**
 * Реализация Detector для последовательного
 * поиска простых чисел в списке.
 */
public class SequentialPrimeDetector implements PrimeDetector {
    private final List<Integer> list;

    /**
     * Конструктор, принимающий список целых чисел.
     */
    public SequentialPrimeDetector(List<Integer> list) {
        this.list = list;
    }

    /**
     * Проверяет, есть ли хотя бы одно непростое число в списке.
     */
    @Override
    public boolean hasNonPrimeNumbers() {
        if (list.isEmpty()) {
            return false;
        }

        for (Integer number : list) {
            if (!isPrime(number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет, является ли переданное число простым.
     */
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
