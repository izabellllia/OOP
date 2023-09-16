package zhitnik;

/**класс Main внутри которого методы heapSort и heapify.*/
public class Main {

    /**heapSort, который принимает массив чисел и выполняет пирамидальную сортировку.*/
    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    /**heapify выполняет операцию "просеивания" элемента вниз по куче.
     * Принимает на вход массив и индекс элемента, который нужно просеять.
     * Внутри heapify происходит сравнение текущего элемента с его дочерними элементами.
     * Если текущий элемент не удовлетворяет свойствам кучи, то он меняется местами с наибольшим
     * (в случае максимальной кучи) или наименьшим (в случае минимальной кучи) из своих дочерних элементов.
     * Затем функция вызывается рекурсивно для просеивания элемента дальше вниз по куче.*/
    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        if (leftChildIdx < n && array[leftChildIdx] > array[largest]) {
            largest = leftChildIdx;
        }

        if (rightChildIdx < n && array[rightChildIdx] > array[largest]) {
            largest = rightChildIdx;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }
}