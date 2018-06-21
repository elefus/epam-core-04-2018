package com.epam.homework;

import java.util.Scanner;
import com.kindet27.matrix.*;

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
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);

        for (int i = matrix.getColumns() - 1; i >= 0; i--) {
            if (arrFullOfZeros(matrix.getRowByInd(i))) {
                matrix = matrix.deleteRow(i);
            }
        }
        for (int i = matrix.getRows() - 1; i >= 0; i--) {
            if (arrFullOfZeros(matrix.getColumnByInd(i))) {
                matrix = matrix.deleteColumn(i);
            }
        }
        matrix.matrixSout2Dim();
    }

    private static boolean arrFullOfZeros(Integer[] arr) {
        for (int anArr : arr) {
            if (anArr != 0) {
                return false;
            }
        }
        return true;
    }
}