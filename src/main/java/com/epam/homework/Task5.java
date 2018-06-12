package com.epam.homework;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        int count = 0;

        Scanner scanner = new Scanner(System.in);

        int wordsCount = Integer.valueOf(scanner.nextLine());

        for (int i=0; i<wordsCount; i++) {
            int countV = 0;
            int countS = 0;
            String line = scanner.next();
            if (line.matches("[a-zA-Z]+")) {

                for (int j=0; j<line.length(); j++) {
                    if ("AEOIUYaeoiuy".indexOf(line.charAt(j)) != -1) countV++;
                    else countS++;
                }
                if (countV == countS) count++;
            }
        }
        System.out.println(count);
    }
}
