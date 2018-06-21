package com.epam.homework;

import com.akalji.genericmatrix.Matrix;

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
        int matrixSize = scanner.nextInt();
        Matrix<Integer> matrix = new Matrix<>(matrixSize);

        int maximalValue = Integer.MIN_VALUE;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();
                matrix.set(i, j, value);
                if (value > maximalValue) {
                    maximalValue = value;
                }
            }
        }

        for (int i = 0; i<matrix.getVsize();i++){
            boolean isNeedToDeleteRow = false;
            for (int j = 0; j < matrix.getHsize(); j++) {
                if (matrix.getElement(i,j)==maximalValue){
                    matrix.deleteColumn(j);
                    isNeedToDeleteRow = true;
                    j--;
                }
            }
            if(isNeedToDeleteRow) {
                matrix.deleteRow(i);
            }
        }


        printMatrix(matrix);
    }

    private static void printMatrix(Matrix<Integer> A) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(A.getVsize());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(A.getHsize());
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < A.getVsize(); i++) {
            for (int j = 0; j < A.getHsize(); j++) {
                stringBuilder.append(A.getElement(i, j));
                if (j < A.getHsize() - 1) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder.toString());
    }
}
