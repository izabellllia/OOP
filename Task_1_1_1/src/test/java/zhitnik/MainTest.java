package zhitnik;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;


/**Тест.*/
public class MainTest {
    @Test
    public void testHeapSort() {
        int[] arr = {9, 5, 2, 7, 1};
        int[] sortedArr = {1, 2, 5, 7, 9};
        Main.heapSort(arr);
        assertArrayEquals(sortedArr, arr);
    }
}