package com.epam.homework;

import java.util.Scanner;

public class Task14 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int amount = scanner.nextInt();
            int initialValue = Integer.MIN_VALUE;
            int localCounter = 1;
            int maxCounter = 1;
            for (int i = 0; i < amount; i++) {
                int currentValue = scanner.nextInt();
                if (i > 0 && currentValue > initialValue) {
                    if (maxCounter < ++localCounter) {
                        maxCounter = localCounter;
                    }
                }
                else {
                    localCounter = 1;
                }
                initialValue = currentValue;
            }
            System.out.println(maxCounter > 1 ? maxCounter : 0);
        }

    }
}