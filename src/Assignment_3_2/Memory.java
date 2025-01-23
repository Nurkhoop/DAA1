package Assignment_3_2;

import java.util.Arrays;

public class Memory {
    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[index] = array[i];
                if (index != i) {
                    array[i] = null;
                }
                index++;
            }
        }
    }
}
