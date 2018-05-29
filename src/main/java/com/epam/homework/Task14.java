package com.epam.homework;

import java.util.Scanner;

public class Task14 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int maxAmount = 0;
            int limit = Integer.parseInt(scanner.nextLine());
            if (limit > 1) {
                int initial = scanner.nextInt();
                int localMax = 0;
                for (int i = 0; i < limit-1; i++) {
                    int current = scanner.nextInt();
                    if (current > initial) {
                        if (i == 0) localMax++;
                        localMax++;
                    } else {
                        if (localMax > maxAmount) maxAmount = localMax;
                        localMax = 0;
                    }
                    initial = current;
                }
            }
            System.out.println(maxAmount);
        }
    }
}