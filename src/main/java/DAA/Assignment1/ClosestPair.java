package DAA.Assignment1;

import java.util.*;

public class ClosestPair {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points) {
        Counters.allocations++;
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        return closest(points, 0, points.length - 1);
    }

    private static double closest(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        double d1 = closest(points, left, mid);
        double d2 = closest(points, mid + 1, right);
        double d = Math.min(d1, d2);

        Counters.allocations++;
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            Counters.comparisons++;
            if (Math.abs(points[i].x - points[mid].x) < d) strip.add(points[i]);
        }
        strip.sort(Comparator.comparingInt(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                Counters.comparisons++;
                double distVal = dist(strip.get(i), strip.get(j));
                Counters.comparisons++;
                if (distVal < d) d = distVal;
            }
        }
        return d;
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                Counters.comparisons++;
                min = Math.min(min, dist(points[i], points[j]));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b) {
        Counters.comparisons++;
        return Math.sqrt((a.x - b.x) * (a.x - b.x) +
                (a.y - b.y) * (a.y - b.y));
    }

    public static void main(String[] args) {
        Point[] points = {new Point(2, 3), new Point(12, 30),
                new Point(40, 50), new Point(5, 1),
                new Point(12, 10), new Point(3, 4)};
        Counters.reset();
        System.out.println("Closest distance: " + closestPair(points));
        System.out.println("Comparisons: " + Counters.comparisons +
                ", Allocations: " + Counters.allocations);
    }
}
