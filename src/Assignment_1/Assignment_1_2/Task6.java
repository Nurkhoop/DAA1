package Assignment_1.Assignment_1_2;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter numbers:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("ENTER")) {
                break;
            }

            sum += Integer.parseInt(input);
        }

        System.out.println(sum);
    }
}
