package com.epam.homework;

import com.kindet27.matrix.*;

import java.util.Scanner;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);

        Integer maxEl = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                maxEl = Math.max(maxEl, matrix.getElement(i, j));
            }
        }
        for (int i = matrix.getColumns(); i >= 0; i--) {
            if (arrContains(matrix.getRowByInd(i), maxEl)) {
                matrix = matrix.deleteRow(i);
            }
        }
        for (int i = matrix.getRows(); i >= 0; i--) {
            if (arrContains(matrix.getColumnByInd(i), maxEl)) {
                matrix = matrix.deleteColumn(i);
            }
        }
        matrix.matrixSout();
    }

    private static boolean arrContains(int[] arr, int target) {
        for (int anArr : arr) {
            if (anArr == target) {
                return true;
            }
        }
        return false;
    }
}
