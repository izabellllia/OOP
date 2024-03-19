package zhitnik;

import java.util.ArrayList;
import java.util.List;
/**
 * Реализация Detector для последовательного
 * поиска простых чисел в списке.
 */

public class ParallelPrimeDetector implements PrimeDetector {
    private final List<Integer> numberList;
    private final int threadCount;

    /**
     * Конструктор, принимающий список целых чисел и значение количества потоков.
     */
    public ParallelPrimeDetector(List<Integer> numberList, int threadCount) {
        this.numberList = numberList;
        this.threadCount = threadCount;
    }

    /**
     * Проверяет есть ли в списке непростые числа
     * Создается список целых чисел для каждого потока
     * Список чисел разделяется на подсписки
     * Затем создается и запускается поток для каждого подсписка чисел
     * Выполняется проверка результатов выполнения потоков.
     */
    @Override
    public boolean hasNonPrimeNumbers(List<Integer> numbers) {
        List<List<Integer>> dataForThreads = splitDataForThreads();
        List<PrimeChecker> threadList = createAndStartThreads(dataForThreads);

        boolean allPrimes = checkResultsAndReturn(threadList);
        return !allPrimes;
    }

    /**
     * Метод принимает список чисел numberList и
     * разделяет его на подсписки для каждого потока
     * в зависимости от их количества.
     * Возвращает список таких подсписков.
     */
    private List<List<Integer>> splitDataForThreads() {
        List<List<Integer>> dataForThreads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            dataForThreads.add(new ArrayList<>());
        }
        for (int i = 0; i < numberList.size(); i++) {
            dataForThreads.get(i % threadCount).add(numberList.get(i));
        }
        return dataForThreads;
    }

    /**
     * Метод принимает список подсписков чисел dataForThreads
     * и создает и запускает потоки для проверки простых чисел.
     */
    private List<PrimeChecker> createAndStartThreads(List<List<Integer>> dataForThreads) {
        List<PrimeChecker> threadList = new ArrayList<>();
        for (var threadData : dataForThreads) {
            PrimeChecker checker = new PrimeChecker(threadData);
            checker.start();
            threadList.add(checker);
        }
        return threadList;
    }

    /**
     * Проверяет результаты выполнения всех
     * потоков в threadList и возвращает их
     * в виде логического значения.
     */
    private boolean checkResultsAndReturn(List<PrimeChecker> threadList) {
        boolean result = true;
        for (var checker : threadList) {
            try {
                checker.join();
                result &= checker.getResult();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Вспомогательный класс для проверки простых чисел
     * в подсписке с использованием отдельного потока.
     */
    public static class PrimeChecker extends Thread {
        private List<Integer> dataList;
        private boolean result;

        PrimeChecker(List<Integer> dataList) {
            this.dataList = dataList;
            this.result = true;
        }

        /**
         * Проходит по каждому числу из списка и вызывает
         * метод isPrime() для проверки числа на простоту.
         */
        @Override
        public void run() {
            for (var number : dataList) {
                boolean isPrime = IsPrime.isPrimeMethod(number);
                result &= isPrime;
            }
        }

        /**Возвращает значение поля result,
         * которое является результатом проверки
         * всех чисел из списка на простоту.
         */
        public boolean getResult() {
            return result;
        }
    }
}
