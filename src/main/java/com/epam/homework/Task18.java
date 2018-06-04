package com.epam.homework;

import java.util.*;

public class Task18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        printMatrix(getMatrix(matrix));
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                if (anAMatrix > max) {
                    max = anAMatrix;
                }
            }
        }
        return max;
    }

    private static int[][] rowDeleting(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length - set.size()][matrix[0].length];
        int zz = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!set.contains(i)) {
                newMatrix[zz++] = matrix[i];
            }
        }
        return newMatrix;
    }

    private static int[][] columnDeleting(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length - set.size()];
        int zz = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                if (!set.contains(y)) {
                    newMatrix[i][zz++] = matrix[i][y];
                }
            }
        }
        return newMatrix;
    }


    private static int[][] getMatrix(int[][] initialMatrix) {

        int max = findMax(initialMatrix);

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int row = 0; row < initialMatrix.length; ++row) {
            for (int col = 0; col < initialMatrix[row].length; ++col) {
                if (initialMatrix[row][col] == max) {
                    rows.add(row);
                    columns.add(col);
                }
            }
        }

        initialMatrix = rowDeleting(initialMatrix, rows);
        initialMatrix = columnDeleting(initialMatrix, columns);
        return initialMatrix;
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

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}