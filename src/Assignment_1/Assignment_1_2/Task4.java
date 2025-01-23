package Assignment_1.Assignment_1_2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age<=20 || age>=60) System.out.println("you don’t have to work.");
    }
}
