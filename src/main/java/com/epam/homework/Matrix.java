package com.epam.homework;

import java.util.*;

class Matrix {

    private ArrayList<Integer[]> matrix;
    private int matrixSize;

    Matrix(int matrixSize) {
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

    void sortMatrixInTheOrderOfTheKthColumn(int numbOfCol) {
        matrix.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[numbOfCol], o2[numbOfCol]);
            }
        });
    }
  
    void shiftRows(int amountShifts) {
        amountShifts %= matrixSize;
        if (amountShifts > 0) {
            shift(matrixSize - amountShifts);
        } else {
            shift(Math.abs(amountShifts));
        }
    }

    private void shift(int amountShifts) {
        for (int i = 0; i < amountShifts; i++) {
            matrix.add(matrix.get(0));
            matrix.remove(0);
        }
    }
}
