package com.epam.homework;


import java.util.Scanner;

public class Task15 {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = readMatrix(scanner);
            int initialSum = 0;
            printSum(matrix ,initialSum);
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
    private static void printSum(int[][] matrix, int initialSum) {
        for (int[] row : matrix) {
            int initialDigit = 0;
            boolean firstFlag = false;
            boolean secondFlag = false;
            int secondDigit = 0;
            for (int i = 0; i < row.length; i++) {
                int aRow = row[i];
                if (aRow > 0) {
                    if (firstFlag) {
                        if (!secondFlag) {
                            secondDigit = i;
                            secondFlag = true;
                        }
                    } else {
                        initialDigit = i;
                        firstFlag = true;
                    }
                }
            }
            for (int z = initialDigit + 1; z < secondDigit; z++) {
                initialSum += row[z];
            }
        }
        System.out.println(initialSum);
    }
}