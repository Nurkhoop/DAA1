package DAA.Assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class MetricsTest {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000, 20000};

        try (FileWriter csv = new FileWriter("results.csv")) {
            csv.write("Algorithm,n,Time(ms),Comparisons,Allocations,Result/Distance\n");

            for (int n : sizes) {
                // ===== MERGE SORT =====
                int[] arrMerge = Metrics.generateRandomArray(n);
                Counters.reset();
                long start = System.nanoTime();
                MergeSort.mergeSort(arrMerge);
                long elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format(Locale.US, "MergeSort,%d,%d,%d,%d,-\n",
                        n, elapsed, Counters.comparisons, Counters.allocations));

                // ===== QUICK SORT =====
                int[] arrQuick = Metrics.generateRandomArray(n);
                Counters.reset();
                start = System.nanoTime();
                QuickSort.quickSort(arrQuick, 0, arrQuick.length - 1);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format(Locale.US, "QuickSort,%d,%d,%d,%d,-\n",
                        n, elapsed, Counters.comparisons, Counters.allocations));

                // ===== DETERMINISTIC SELECT =====
                int[] arrSelect = Metrics.generateRandomArray(n);
                int k = (int) (Math.random() * n);
                Counters.reset();
                start = System.nanoTime();
                int result = DeterministicSelect.select(arrSelect, k);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format(Locale.US, "DeterministicSelect,%d,%d,%d,%d,%d\n",
                        n, elapsed, Counters.comparisons, 0, result));

                // ===== CLOSEST PAIR =====
                int ptsCount = Math.min(n, 2000);
                ClosestPair.Point[] pts = new ClosestPair.Point[ptsCount];
                for (int i = 0; i < ptsCount; i++) {
                    pts[i] = new ClosestPair.Point(
                            (int) (Math.random() * 10000),
                            (int) (Math.random() * 10000)
                    );
                }
                Counters.reset();
                start = System.nanoTime();
                double distance = ClosestPair.closestPair(pts);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format(Locale.US, "ClosestPair,%d,%d,%d,%d,%.5f\n",
                        ptsCount, elapsed, 0, 0, distance));
            }

            System.out.println("Results saved to results.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
