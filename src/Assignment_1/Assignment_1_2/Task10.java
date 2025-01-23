package Assignment_1.Assignment_1_2;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start:");
        int start = scanner.nextInt();

        System.out.print("End:");
        int end = scanner.nextInt();

        System.out.print("Multiple:");
        int multiple = scanner.nextInt();

        int sum = 0;
        for(int i = start; i < end; i++){
            if(i % multiple != 0){
                continue;
            }
            sum += i;
        }
        System.out.println(sum);
    }
}
