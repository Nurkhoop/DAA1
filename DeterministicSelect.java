package DAA.Assignment1;

import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot);

        int rank = pivotIndex - left + 1; // position of pivot
        Counters.comparisons++;
        if (k == rank) return arr[pivotIndex];
        else if (k < rank) return select(arr, left, pivotIndex - 1, k);
        else return select(arr, pivotIndex + 1, right, k - rank);
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            Arrays.sort(arr, left, right + 1);
            Counters.allocations += (right - left + 1);
            return arr[left + n / 2];
        }

        int[] medians = new int[(n + 4) / 5];
        for (int i = 0; i < medians.length; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            Counters.allocations += (subRight - subLeft + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }
        return medianOfMedians(medians, 0, medians.length - 1);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            Counters.comparisons++;
            while (arr[left] < pivot) {
                Counters.comparisons++;
                left++;
            }
            while (arr[right] > pivot) {
                Counters.comparisons++;
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        Counters.allocations++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;

        Counters.reset();
        int result = select(arr, k);

        System.out.println(k + "-th smallest element is: " + result);
        System.out.printf("Comparisons=%d, Allocations=%d%n",
                Counters.comparisons, Counters.allocations);
    }
}
