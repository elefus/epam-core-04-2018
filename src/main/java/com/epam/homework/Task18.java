package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
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
     *  3
     *  2  1 -3
     * -2  3  2
     * -1  0  0
     *
     * Выходные данные:
     *  2
     *  2
     *  2 -3
     * -1  0
     *
     *
     *
     * Входные данные:
     *  4
     *  3 -2 -4  1
     *  1  4  4  2
     * -1  0 -3  1
     *  0  2  1  3
     *
     * Выходные данные:
     *  3
     *  2
     *  3  1
     * -1  1
     *  0  3
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        printMatrix(discardRowsAndColsWithMaxElement(matrix));

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

    private static int[][] discardRowsAndColsWithMaxElement(int[][] matrix){

        int dimension = matrix.length;
        int maxElement = matrix[0][0];
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] > maxElement){
                    maxElement = matrix[i][j];
                }
            }
        }

        HashSet<Integer> rowsToDiscard = new HashSet<>();
        HashSet<Integer> colsToDiscard = new HashSet<>();

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] == maxElement){
                    rowsToDiscard.add(i);
                    colsToDiscard.add(j);
                }
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
