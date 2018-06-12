package com.epam.homework;

import java.util.*;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     * <p>
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     * <p>
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixDimension = scanner.nextInt();
        Integer[][] matrix = readMatrix(scanner, matrixDimension);
        int valueOfShift = scanner.nextInt();
        valueOfShift %= matrixDimension;

        Integer[][] shiftedMatrix = shift(matrix, valueOfShift);

        List<Integer> matrixRow = new ArrayList<Integer>() {
            public String toString() {
                Iterator<Integer> iterator = iterator();
                StringBuilder stringBuilder = new StringBuilder();

                for (; ; ) {
                    int integer = iterator.next();
                    stringBuilder.append(integer);
                    if (!iterator.hasNext())
                        return stringBuilder.toString();
                    stringBuilder.append(' ');
                }
            }
        };
        System.out.println(matrixDimension);
        for (int i = 0; i < matrixDimension; i++) {
            matrixRow.clear();
            matrixRow.addAll(Arrays.asList(shiftedMatrix[i]));
            System.out.println(matrixRow);
        }
    }

    private static Integer[][] shift(Integer[][] matrix, int shift) {
        int dimension = matrix.length;
        int startCopyPosition = shift > 0 ? shift : dimension - (-shift);
        Integer[][] resultMatrix = new Integer[dimension][dimension];

        if (shift == 0) {
            return matrix;
        }

        System.arraycopy(matrix, dimension - startCopyPosition, resultMatrix, 0, startCopyPosition);
        System.arraycopy(matrix, 0, resultMatrix, startCopyPosition, dimension - startCopyPosition);

        return resultMatrix;
    }

    private static Integer[][] readMatrix(Scanner scanner, int dimension) {
        Integer[][] matrix = new Integer[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
