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
        return list.stream().anyMatch(number -> !IsPrime.isPrimeMethod(number));
    }
}
