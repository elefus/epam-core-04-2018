package com.epam.homework;

import com.akalji.genericmatrix.Matrix;

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
        int matrixSize = scanner.nextInt();

        Matrix<Integer> matrix = new Matrix<>(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix.set(i, j, scanner.nextInt());
            }
        }

        int degrees = scanner.nextInt();

        if (degrees != 0) {
            Matrix.DIRECTION direction;
            if (degrees > 0) {
                direction = Matrix.DIRECTION.CLOCKWISE;
            } else {
                direction = Matrix.DIRECTION.COUNTERCLOCKWISE;
            }

            // Откидываем переодичность в поворотах
            // Заменив операции поворотами на 90 и 180 градусов
            if (Math.abs(degrees) % 4 / 2 > 0) {
                matrix.rotate180();
            }
            if (Math.abs(degrees) % 4 % 2 > 0) {
                matrix.rotate90(direction);
            }
        }
        printMatrix(matrix);
    }


    private static void printMatrix(Matrix<Integer> A) {
        StringBuilder stringBuilder = new StringBuilder();
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
