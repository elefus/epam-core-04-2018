package com.epam.homework;

import com.kindet27.matrix.*;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     * ...
     * case  -5: поворот на 450* против часовой стрелки
     * case  -4: поворот на 360* против часовой стрелки
     * case  -3: поворот на 270* против часовой стрелки
     * case  -2: поворот на 180* против часовой стрелки
     * case  -1: поворот на  90* против часовой стрелки
     * case   0: поворот не осуществляется
     * case   1: поворот на  90* по     часовой стрелке
     * case   2: поворот на 180* по     часовой стрелке
     * case   3: поворот на 270* по     часовой стрелке
     * case   4: поворот на 360* по     часовой стрелке
     * case   5: поворот на 450* по     часовой стрелке
     * ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1  -2   1
     * -3   0   2
     * 3  -2   1
     * 1
     * <p>
     * Выходные данные:
     * 3
     * 3  -3   1
     * -2   0  -2
     * 1   2   1
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 2
     * 9  3
     * 2  4
     * -2
     * <p>
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);
        int degree = scanner.nextInt();
        degree = ((degree % 4) + 4) % 4;
        switch (degree) {
            case 1:
                rotate90(matrix).matrixSout();
                break;
            case 2:
                rotate180(matrix).matrixSout();
                break;
            case 3:
                rotate270(matrix).matrixSout();
                break;
        }
    }
    private static Matrix rotate90(Matrix matrix) {
        int size = matrix.getRows();
        Matrix<Integer> rotatedMatrix = new Matrix<>(size);
        for (int i = 0; i < size ; i++) {
            int k = size -1;
            for (int j = 0; j < size ; j++) {
                rotatedMatrix.setElement(matrix.getElement(k--, i) ,i , j);
            }
        }
        return rotatedMatrix;
    }

    private static Matrix rotate180(Matrix matrix){
        int size = matrix.getRows();
        Matrix<Integer> rotatedMatrix = new Matrix<>(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedMatrix.setElement(matrix.getElement(size -1 - i, size - 1 -j) , i, j);
            }
        }
        return rotatedMatrix;
    }
    private static Matrix rotate270(Matrix matrix){
        int size = matrix.getRows();
        Matrix<Integer> rotatedMatrix = new Matrix<>(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedMatrix.setElement(matrix.getElement(j, size - 1 - i) , i, j);
            }
        }
        return rotatedMatrix;
    }
}
