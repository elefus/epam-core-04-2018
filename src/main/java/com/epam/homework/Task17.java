package com.epam.homework;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);
        System.out.println(determinant(matrix));

    }

    private static int determinant(int[][] matrix) {
        int sum = 0;
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            sum += (matrix[0][i] * Math.pow((-1), i) * determinant(createNewMatrix(matrix, i)));
        }
        return sum;
    }

    private static int[][] createNewMatrix(int[][] matrix, int col) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];

        for (int prevRow = 0, newRow = 0; prevRow < matrix.length; prevRow++, newRow++) {
            if (0 != prevRow) {
                for (int prevCol = 0, newCol = 0; prevCol < matrix.length; prevCol++, newCol++) {
                    if (col != prevCol) {
                        newMatrix[newRow][newCol] = matrix[prevRow][prevCol];
                    } else {
                        newCol--;
                    }
                }
            } else {
                newRow--;
            }
        }
        return newMatrix;
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
