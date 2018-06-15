package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  4
     *  2  0  0 -1
     *  0  0  0  0
     *  0  0  0  3
     * -3  0  0  1
     *
     * Выходные данные:
     *  3
     *  2
     *  2 -1
     *  0  3
     * -3  1
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        printMatrix(discardRowsAndColsFilledWithZeros(matrix));

    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        int vertical = matrix.length;
        int horizontal = matrix[0].length;
        System.out.println(vertical);
        System.out.println(horizontal);
        for (int row = 0; row < vertical; ++row) {
            for (int col = 0; col < horizontal; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] discardRowsAndColsFilledWithZeros(int[][] matrix){

        int dimension = matrix.length;
        HashSet<Integer> rowsToDiscard = new HashSet<>();
        HashSet<Integer> colsToDiscard = new HashSet<>();

        for (int i = 0; i < dimension; i++){
            int zerosRow = 0;
            int zerosCol = 0;
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] == 0){
                    zerosRow++;
                }
                if (matrix[j][i] == 0){
                    zerosCol++;
                }
            }
            if (zerosRow == dimension) {
                rowsToDiscard.add(i);
            }
            if (zerosCol == dimension){
                colsToDiscard.add(i);
            }
        }

        int[][] newMatrix = new int[dimension - rowsToDiscard.size()][dimension - colsToDiscard.size()];

        int iNew = 0;
        int jNew = 0;

        for (int i = 0; i < dimension; i++){
            if (!rowsToDiscard.contains(i)) {
                jNew = 0;
                for (int j = 0; j < dimension; j++) {
                    if (!colsToDiscard.contains(j)){
                        newMatrix[iNew][jNew] = matrix[i][j];
                        jNew++;
                    }
                }
                iNew++;
            }
        }

        return newMatrix;

    }
}
