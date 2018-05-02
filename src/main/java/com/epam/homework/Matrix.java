package com.epam.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Matrix {

    private int[][] matrix;

    Matrix(int matrixSize) {
        matrix = new int[matrixSize][matrixSize];
    }

    void setMatrix(Scanner in) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    void printMatrix() {
        System.out.println(matrix.length);
        for (int[] column : matrix) {
            for (int row : column) {
                System.out.printf("%5d ", row);
            }
            System.out.println();
        }
    }

    void sortMatrixInTheOrderOfTheKthColumn(int numbOfCol) {
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[numbOfCol], o2[numbOfCol]);
            }
        });
    }

    void shiftRows(int amountShifts) {
        if (amountShifts > 0) {
            shiftToDown(amountShifts);
        } else if (amountShifts < 0) {
            shiftToUP(Math.abs(amountShifts));
        }
    }

    private void shiftToDown(int amountPosition) {
        for (int i = 0; i < amountPosition; i++) {
            for (int j = matrix.length - 1; j > 0; j--) {
                swapRows(j, j - 1);
            }
        }
    }

    private void shiftToUP(int amountPosition) {
        for (int i = 0; i < amountPosition; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                swapRows(j, j + 1);
            }
        }
    }

    private void swapRows(int row1, int row2) {
        int[] tempRow = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tempRow;
    }


}
