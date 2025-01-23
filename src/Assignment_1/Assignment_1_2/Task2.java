package Assignment_1.Assignment_1_2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        if (age >=18 & age<=28) {
            System.out.println(name + ", come to the military registration and enlistment office");
        }
    }
}
