package DAA.Assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000, 20000};
        Random rand = new Random();

        try (FileWriter csv = new FileWriter("results.csv")) {
            csv.write("Algorithm,n,Time(ms),Comparisons,Allocations,Result/Distance\n");

            for (int n : sizes) {
                // ===== MERGE SORT =====
                int[] arrMerge = rand.ints(n, 0, 1_000_000).toArray();
                Counters.reset();
                long start = System.nanoTime();
                MergeSort.mergeSort(arrMerge);
                long elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format("MergeSort,%d,%d,%d,%d,-\n",
                        n, elapsed, Counters.comparisons, Counters.allocations));

                // ===== QUICK SORT =====
                int[] arrQuick = rand.ints(n, 0, 1_000_000).toArray();
                Counters.reset();
                start = System.nanoTime();
                QuickSort.quickSort(arrQuick, 0, arrQuick.length - 1);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format("QuickSort,%d,%d,%d,%d,-\n",
                        n, elapsed, Counters.comparisons, Counters.allocations));

                // ===== DETERMINISTIC SELECT =====
                int[] arrSelect = rand.ints(n, 0, 1_000_000).toArray();
                int k = rand.nextInt(n);
                Counters.reset();
                start = System.nanoTime();
                int val = DeterministicSelect.select(arrSelect, k);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format("DeterministicSelect,%d,%d,%d,%d,%d\n",
                        n, elapsed, Counters.comparisons, 0, val));

                // ===== CLOSEST PAIR =====
                int ptsCount = Math.min(n, 2000);
                ClosestPair.Point[] pts = new ClosestPair.Point[ptsCount];
                for (int i = 0; i < ptsCount; i++) {
                    pts[i] = new ClosestPair.Point(rand.nextInt(10000), rand.nextInt(10000));
                }
                Counters.reset();
                start = System.nanoTime();
                double distance = ClosestPair.closestPair(pts);
                elapsed = (System.nanoTime() - start) / 1_000_000;
                csv.write(String.format("ClosestPair,%d,%d,%d,%d,%.5f\n",
                        ptsCount, elapsed, 0, 0, distance));
            }

            System.out.println("Results saved to results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


