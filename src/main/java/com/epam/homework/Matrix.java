package com.epam.homework;

import java.util.Scanner;

public class Matrix {

    private static int dimension;
    private static int[][] matrix;

    Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new int[dimension][dimension];
    }

    public void setMatrix(Scanner scanner) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void setMatrixElement(int row, int column, int element) {
        matrix[row][column] = element;
    }

    public int getMatrixElement(int row, int column) {
        return matrix[row][column];
    }

    public int getDimension() {
        return dimension;
    }

    public static void printMatrix() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    public int calculateMatrixDeterminant(Matrix matrix) {
        if(matrix.getDimension() == 1) {
            return matrix.getMatrixElement(0, 0);
        }

        if(matrix.getDimension() == 2) {
            return matrix.getMatrixElement(0, 0) * matrix.getMatrixElement(1, 1)
                    - matrix.getMatrixElement(1, 0) * matrix.getMatrixElement(0, 1);
        }

        for (int i = 0; i < dimension; i++) {
            return 
        }
    }
}
