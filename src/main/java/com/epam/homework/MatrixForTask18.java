package com.epam.homework;

import java.util.*;

class MatrixForTask18 {

    private List<List<Integer>> matrix;
    private int amountOfRows;
    private int amountOfColumns;

    MatrixForTask18(int matrixSize) {
        this.matrix = new ArrayList<>();
        this.amountOfRows = matrixSize;
        this.amountOfColumns = matrixSize;
    }

    void setMatrix(Scanner in) {
        for (int i = 0; i < amountOfRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < amountOfColumns; j++) {
                temp.add(in.nextInt());
            }
            matrix.add(temp);
        }
    }

    void printMatrix() {
        System.out.println(amountOfRows);
        System.out.println(amountOfColumns);
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.printf("%5d ", element);
            }
            System.out.println();
        }
    }

    void deleteRowsAndColumnsWithMaxElements() {
        if (amountOfColumns == 1 || amountOfRows == 1) {
            return;
        }

        List<List<Integer>> newMatrix = new ArrayList<>();
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < amountOfRows; i++) {
            for (int j = 0; j < amountOfColumns; j++) {
                if(matrix.get(i).get(j) > max){
                    max = matrix.get(i).get(j);
                    rows = new HashSet<>();
                    columns = new HashSet<>();
                }

                if(matrix.get(i).get(j) == max){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < amountOfRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < amountOfRows; j++) {
                if(!(rows.contains(i) || columns.contains(j))){
                    temp.add(matrix.get(i).get(j));
                }
            }
            if(!temp.isEmpty()) {
                newMatrix.add(temp);
            }
        }

        this.matrix = newMatrix;
        this.amountOfRows = newMatrix.size();
        this.amountOfColumns = newMatrix.get(0).size();
    }

}
