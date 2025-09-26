package DAA.Assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSortPerformance() {
        int n = 100_000;

        // Генерируем случайный массив
        int[] arr = new Random().ints(n, 0, 1_000_000).toArray();
        int[] copy = Arrays.copyOf(arr, arr.length);

        // Сброс счётчиков перед сортировкой
        Counters.reset();

        // Сортировка твоим QuickSort с рандомизированным pivot
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Сортируем копию стандартным Arrays.sort для проверки
        Arrays.sort(copy);

        // Проверяем, что массивы совпадают
        assertArrayEquals(copy, arr);

        System.out.println("QuickSort n=" + n);
        System.out.println("Comparisons: " + Counters.comparisons);
        System.out.println("Allocations: " + Counters.allocations);
    }
}
