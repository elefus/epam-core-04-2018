package com.epam.homework;

import java.util.Scanner;

public class Matrix {

    private static int dimension;
    private static int[][] matrix;

    Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new int[dimension][dimension];
    }

    Matrix(int[][] arrayForMatrix) {
        dimension = arrayForMatrix.length;
        matrix = arrayForMatrix;
    }

    public void setMatrix(Scanner scanner) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
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
        if(this.getDimension() == 1) {
            return matrix.matrix[0][0];
        }

        if (this.getDimension() == 2) {
            return matrix.matrix[0][0] * matrix.matrix [1][1] - matrix.matrix[0][1] * matrix.matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < dimension; i++) {
            int elementToMultiply = (i % 2 == 0) ? matrix.matrix[0][i] : - matrix.matrix[0][i];
            determinant += elementToMultiply * calculateMatrixDeterminant(this.getSubmatrix(i, i));
        }

        return determinant;
    }

    public Matrix getSubmatrix(int minorColumn, int minorRow) {
        int[][] arrayForSubmatrix = new int[dimension - 1][dimension - 1];

        for (int i = 0; i < dimension; i++) {
            if (i == minorRow) {
                continue;
            }

            int destinationRow = (i > minorRow) ? i - 1 : i;
            System.arraycopy(matrix[i], 0, arrayForSubmatrix[destinationRow], 0, minorColumn);
            System.arraycopy(matrix[i], minorColumn + 1, arrayForSubmatrix[destinationRow], minorColumn, (dimension - 1) - minorColumn);
        }

        Matrix submatrix = new Matrix(arrayForSubmatrix);
        System.out.println(" ");
        submatrix.printMatrix();
        System.out.println(" ");
        return submatrix;
    }
}
