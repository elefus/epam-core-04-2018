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
                    if (i == 0) localMax++;
                    int current = scanner.nextInt();
                    if (current > initial) {
                        localMax++;
                    } else {
                        if (localMax > maxAmount) maxAmount = localMax;
                        localMax = 0;
                    }
                    initial = current;
                }
                if (maxAmount == 0 && localMax > 0) maxAmount = localMax;
            }
            System.out.println(maxAmount);
        }
    }
}