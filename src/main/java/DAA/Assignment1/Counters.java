package DAA.Assignment1;

public class Counters {
    public static long comparisons = 0;
    public static long allocations = 0;

    public static void reset() {
        comparisons = 0;
        allocations = 0;
    }
}
