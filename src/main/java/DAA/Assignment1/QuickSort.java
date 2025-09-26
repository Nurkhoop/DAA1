package DAA.Assignment1;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    private static void swap(int[] a, int i, int j) {
        Counters.allocations++;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int store = left;
        for (int i = left; i < right; i++) {
            Counters.comparisons++;
            if (arr[i] <= pivot) {
                swap(arr, store++, i);
            }
        }
        swap(arr, store, right);
        return store;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);

            if (p - left < right - p) {
                quickSort(arr, left, p - 1);
                quickSort(arr, p + 1, right);
            } else {
                quickSort(arr, p + 1, right);
                quickSort(arr, left, p - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        Counters.reset();
        quickSort(arr, 0, arr.length - 1);

        System.out.println("QuickSort result: " + Arrays.toString(arr));
        System.out.printf("Comparisons=%d, Allocations=%d%n",
                Counters.comparisons, Counters.allocations);
    }
}
