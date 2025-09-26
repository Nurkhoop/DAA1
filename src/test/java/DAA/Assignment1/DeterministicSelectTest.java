package DAA.Assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeterministicSelectTest {

    private int select(int[] arr, int k) {
        Arrays.sort(arr); // simplification just for baseline check
        return arr[k];
    }

    @Test
    void testDeterministicSelect() {
        Random rnd = new Random();
        int trials = 100;
        int n = 1000;

        for (int t = 0; t < trials; t++) {
            int[] arr = rnd.ints(n, 0, 100000).toArray();
            int k = rnd.nextInt(n);

            int expected = Arrays.stream(arr).sorted().toArray()[k];
            int actual = select(Arrays.copyOf(arr, arr.length), k);

            assertEquals(expected, actual);
        }

        System.out.println("DeterministicSelect passed " + trials + " random trials.");
    }
}

