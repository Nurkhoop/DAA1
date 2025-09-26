package DAA.Assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    static int comparisons = 0;
    static int recursionDepth = 0;
    static int maxDepth = 0;

    // helper merge with counting
    private void merge(int[] arr, int l, int m, int r, int[] buffer) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            comparisons++;
            if (arr[i] <= arr[j]) buffer[k++] = arr[i++];
            else buffer[k++] = arr[j++];
        }
        while (i <= m) buffer[k++] = arr[i++];
        while (j <= r) buffer[k++] = arr[j++];
        for (i = l; i <= r; i++) arr[i] = buffer[i];
    }

    private void mergeSort(int[] arr, int l, int r, int[] buffer, int depth) {
        recursionDepth = depth;
        if (recursionDepth > maxDepth) maxDepth = recursionDepth;

        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m, buffer, depth + 1);
            mergeSort(arr, m + 1, r, buffer, depth + 1);
            merge(arr, l, m, r, buffer);
        }
    }

    @Test
    void testMergeSortPerformance() {
        int n = 100000; // array size
        int[] arr = new Random().ints(n, 0, 1_000_000).toArray();
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1, new int[arr.length], 1);
        long end = System.nanoTime();

        Arrays.sort(copy); // ground truth
        assertArrayEquals(copy, arr);

        System.out.println("MergeSort n=" + n);
        System.out.println("Time (ms): " + (end - start) / 1_000_000.0);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Max Recursion Depth: " + maxDepth);
    }
}
