package com.epam.homework;

import java.lang.reflect.Array;
import java.util.*;

class MatrixForTask17 {

    private ArrayList<Integer[]> matrix;
    private int matrixSize;

    MatrixForTask17(int matrixSize) {
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


    int getDeterminant() {
        return calculateDeterminant(this.matrix);
    }

    private int calculateDeterminant(ArrayList<Integer[]> matrix) {
        if (matrix.size() == 1) {
            return matrix.get(0)[0];
        }

        int determinant = 0;
        for (int i = 0; i < matrix.size(); i++) {
            determinant += Math.pow(-1, i) * matrix.get(0)[i] * calculateDeterminant(getMinor(matrix, i));
        }

        return determinant;
    }


    private ArrayList<Integer[]> getMinor(ArrayList<Integer[]> matrix, int column) {
        ArrayList<Integer[]> minor = new ArrayList<>();

        for (int i = 1; i < matrix.size(); i++) {
            Integer[] temp = new Integer[matrix.size() - 1];
            int matrixCount = 0;
            int minorCount = 0;
            while (matrixCount < matrix.size()) {
                if (column != matrixCount) {
                    temp[minorCount++] = matrix.get(i)[matrixCount];
                }
                matrixCount++;
            }
            minor.add(temp);
        }
        return minor;


    }
}