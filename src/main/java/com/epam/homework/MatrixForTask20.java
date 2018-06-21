package com.epam.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

class MatrixForTask20 {

    private List<List<Integer>> matrix;
    private int matrixSize;

    MatrixForTask20(int matrixSize) {
        this.matrix = new ArrayList<>();
        this.matrixSize = matrixSize;
    }

    void setMatrix(Scanner in) {
        for (int i = 0; i < matrixSize; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrixSize; j++) {
                temp.add(in.nextInt());
            }
            matrix.add(temp);
        }
    }

    void printMatrix() {
        System.out.println(matrixSize);
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.printf("%5d ", element);
            }
            System.out.println();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class coordinate {
        int row;
        int column;
    }

    void moveElementMinElem(int targetRow, int targetColumn) {
        int min = Integer.MAX_VALUE;
        coordinate minElem = new coordinate();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix.get(i).get(j) < min) {
                    min = matrix.get(i).get(j);
                    minElem = new coordinate(i, j);
                }
            }
        }

        swapRows(targetRow, minElem.getRow());
        swapColumns(targetColumn, minElem.getColumn());

    }

    private void swapRows(int row1, int row2) {
        List<Integer> temp = matrix.get(row2);
        matrix.add(row2, matrix.get(row1));
        matrix.remove(row2 + 1);
        matrix.add(row1, temp);
        matrix.remove(row1 + 1);
    }

    private void swapColumns(int column1, int column2) {

        for (int i = 0; i < matrixSize; i++) {
            int temp = matrix.get(i).get(column2);
            matrix.get(i).add(column2, matrix.get(i).get(column1));
            matrix.get(i).remove(column2 + 1);
            matrix.get(i).add(column1, temp);
            matrix.get(i).remove(column1 + 1);
        }
    }
}
