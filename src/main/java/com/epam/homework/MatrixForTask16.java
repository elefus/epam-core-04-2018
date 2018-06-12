package com.epam.homework;


import java.util.*;

class MatrixForTask16 {

    private ArrayList<Integer[]> matrix;
    private int matrixSize;

    MatrixForTask16(int matrixSize) {
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

    void rotate(int degree) {
        if (degree == 0) {
            return;
        } else if (degree < 0) {
            degree = 4 + (degree % 4);
        } else {
            degree %= 4;
        }

        switch (degree) {
            case 1:
                rotate90Degrees();
                break;
            case 2:
                rotate90Degrees();
                rotate90Degrees();
                break;
            case 3:
                rotate90Degrees();
                rotate90Degrees();
                rotate90Degrees();
                break;
        }
    }

    private void rotate90Degrees() {
        int temp;
        for (int i = 0; i <= matrixSize / 2; i++) {
            for (int j = i; j < matrixSize - i - 1; j++) {
                temp = matrix.get(i)[j];
                matrix.get(i)[j] = matrix.get(matrixSize - j - 1)[i];
                matrix.get(matrixSize - j - 1)[i] = matrix.get(matrixSize - i - 1)[matrixSize - j - 1];
                matrix.get(matrixSize - i - 1)[matrixSize - j - 1] = matrix.get(j)[matrixSize - i - 1];
                matrix.get(j)[matrixSize - i - 1] = temp;
            }
        }
    }


}
