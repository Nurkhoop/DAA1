package DAA.Assignment1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    private double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    private double bruteForce(Point[] pts) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < pts.length; i++) {
            for (int j = i + 1; j < pts.length; j++) {
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }

    // Utility: strip check
    private double stripClosest(Point[] strip, int size, double d) {
        Arrays.sort(strip, 0, size, Comparator.comparingDouble(p -> p.y));
        double min = d;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, dist(strip[i], strip[j]));
            }
        }
        return min;
    }

    // Recursive divide-and-conquer
    private double closestUtil(Point[] pts, int l, int r) {
        if (r - l <= 3) {
            return bruteForce(Arrays.copyOfRange(pts, l, r + 1));
        }

        int mid = (l + r) / 2;
        Point midPoint = pts[mid];

        double dl = closestUtil(pts, l, mid);
        double dr = closestUtil(pts, mid + 1, r);
        double d = Math.min(dl, dr);

        Point[] strip = new Point[r - l + 1];
        int j = 0;
        for (int i = l; i <= r; i++) {
            if (Math.abs(pts[i].x - midPoint.x) < d) {
                strip[j++] = pts[i];
            }
        }

        return Math.min(d, stripClosest(strip, j, d));
    }

    private double closestPair(Point[] pts) {
        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));
        return closestUtil(pts, 0, pts.length - 1);
    }

    @Test
    void testClosestPairSmall() {
        Random rnd = new Random();
        int n = 500; // small, to compare with brute force
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++)
            pts[i] = new Point(rnd.nextDouble(), rnd.nextDouble());

        double brute = bruteForce(pts);
        double fast = closestPair(Arrays.copyOf(pts, pts.length));

        assertEquals(brute, fast, 1e-6); // both should match
        System.out.println("ClosestPair small test passed: n=" + n);
    }

    @Test
    void testClosestPairLarge() {
        Random rnd = new Random();
        int n = 20000; // only fast algorithm
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++)
            pts[i] = new Point(rnd.nextDouble(), rnd.nextDouble());

        long start = System.nanoTime();
        double fast = closestPair(pts);
        long end = System.nanoTime();

        assertTrue(fast >= 0);
        System.out.println("ClosestPair large test done: n=" + n);
        System.out.println("Time (ms): " + (end - start) / 1_000_000.0);
    }
}
