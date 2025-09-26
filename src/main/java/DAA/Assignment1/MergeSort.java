package DAA.Assignment1;

import java.util.Arrays;

public class MergeSort {
    private static final int CUTOFF = 10; // small-n cutoff

    public static void mergeSort(int[] arr) {
        Counters.allocations++;
        int[] buffer = new int[arr.length]; // reusable buffer
        mergeSort(arr, buffer, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (right - left <= CUTOFF) {
            insertionSort(arr, left, right); // cutoff to insertion sort
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, buffer, left, mid);
        mergeSort(arr, buffer, mid + 1, right);
        merge(arr, buffer, left, mid, right);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        // Copy into buffer
        for (int i = left; i <= right; i++) {
            buffer[i] = arr[i];
        }

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            Counters.comparisons++;
            if (buffer[i] <= buffer[j]) arr[k++] = buffer[i++];
            else arr[k++] = buffer[j++];
        }
        while (i <= mid) arr[k++] = buffer[i++];
        while (j <= right) arr[k++] = buffer[j++];
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left) {
                Counters.comparisons++; // сравнение arr[j] и key
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 5, 6, 2, 8};
        mergeSort(arr);
        System.out.println("MergeSort result: " + Arrays.toString(arr));
    }
}
