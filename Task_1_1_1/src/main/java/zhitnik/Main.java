package zhitnik;

public class Main { //объявляем класс Main
    public static void heapSort(int[] array) {
        int n = array.length; //иниц n с длиной массива

        //Начинаем построение max-кучи. Идем по элементам с конца до середины
        for (int i = n / 2 - 1; i >= 0; i--) {
            //Внутри цикла вызываем метод heapify для каждого элемента массива.
            heapify(array, n, i);
        }
        // извлекаем элементы из кучи по одному и перестраиваем кучу
        for (int i = n - 1; i >= 0; i--) {
            // Внутри цикла перемещаем текущий корень (наибольший элемент) в конец массива
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем метод heapify на уменьшенной куче (размер уменьшается на каждой итерации цикла)
            heapify(array, i, 0);
        }
    }


    public static void heapify(int[] array, int n, int i) {
        // индекс текущего элемента, который считаем наибольшим
        int largest = i;
        //Вычисляем индексы левого и правого дочерних элементов относительно текущего элемента
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        /* Проверяем, если левый дочерний элемент меньше размера массива и значение левого
        * дочернего элемента больше значения наибольшего элемента (array[leftChildIdx] > array[largest]),
        * то обновляем значение переменной largest на индекс левого дочернего элемента
         */
        if (leftChildIdx < n && array[leftChildIdx] > array[largest]) {
            largest = leftChildIdx;
        }
        //проверяем дочерние элементы и обновляем значение largest
        if (rightChildIdx < n && array[rightChildIdx] > array[largest]) {
            largest = rightChildIdx;
        }
        // Проверяем, если наибольший элемент не является корнем (текущим индексом i),
        // то меняем местами значения текущего элемента и наибольшего элемента в массиве
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            //Рекурсивно вызываем метод heapify для поддерева с новым наибольшим элементом
            heapify(array, n, largest);
        }
    }
}