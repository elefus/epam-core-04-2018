package com.epam.homework;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Integer strAmount = scanner.nextInt();
        scanner.nextLine();

        Integer average = 0;
        String[] result = new String[strAmount];
        for (int i = 0; i < strAmount; i++) {
            result[i] = scanner.nextLine();
            average += result[i].length();
        }

        average = average / strAmount;

        System.out.println("AVERAGE (" + average + ")");
        for (String current : result) {
            if (current.length() < average)
                System.out.println("(" + current.length() + "): " + current);
        }
    }
}
