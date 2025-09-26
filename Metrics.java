package DAA.Assignment1;

import java.util.Random;

public class Metrics {
    private static final Random random = new Random();

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = random.nextInt(100_000);
        return arr;
    }

    public static ClosestPair.Point[] generateRandomPoints(int n) {
        ClosestPair.Point[] pts = new ClosestPair.Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new ClosestPair.Point(
                    (int) (random.nextDouble() * 10000),
                    (int) (random.nextDouble() * 10000)
            );
        }
        return pts;
    }
}
