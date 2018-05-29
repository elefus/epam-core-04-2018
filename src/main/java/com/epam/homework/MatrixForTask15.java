package com.epam.homework;

import java.util.*;

class MatrixForTask15 {

    private ArrayList<Integer[]> matrix;
    private int matrixSize;

    MatrixForTask15(int matrixSize) {
        this.matrix = new ArrayList<>();
        this.matrixSize = matrixSize;
    }

    void setMatrix(Scanner in) {
        for (int i = 0; i < matrixSize; i++) {
            Integer[] temp = new Integer[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                temp[j] = in.nextInt();
            }
            matrix.add(temp);
        }
    }

    void printMatrix() {
        System.out.println(matrixSize);
        for (Integer[] row : matrix) {
            for (Integer element : row) {
                System.out.printf("%5d ", element);
            }
            System.out.println();
        }
    }

    int getSumBetweenFirstAndLastPositiveNumber() {
        int result = 0;
        int tempSum = 0;

        for (Integer[] row : matrix) {
            out:
            for (int i = 0; i < row.length; i++) {
                if (row[i] > 0) {
                    for (int j = i + 1; j < row.length; j++) {
                        if (row[j] > 0) {
                            result += tempSum;
                            tempSum = 0;
                            break out;
                        }
                        tempSum += row[j];
                    }
                }
                tempSum = 0;
            }
        }
        return result;
    }
}
