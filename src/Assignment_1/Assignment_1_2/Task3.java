package Assignment_1.Assignment_1_2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter body temperature: ");
        double temperature = scanner.nextDouble();

        boolean isHigh = temperature > 37.5;
        boolean isLow = temperature < 36.0;

        if (isHigh) {
            System.out.println("Body temperature is high.");
        } else if (isLow) {
            System.out.println("Body temperature is low");
        } else {
            System.out.println("Body temperature is normal");
        }
    }
}
