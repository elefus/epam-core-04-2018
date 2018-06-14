package com.epam.homework;

import java.util.*;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     * <p>
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixDimension = scanner.nextInt();
        Integer[][] matrix = readMatrix(scanner, matrixDimension);
        int sortColumnNumber = scanner.nextInt();

        Arrays.sort(matrix, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[sortColumnNumber].compareTo(o2[sortColumnNumber]);
            }
        });

        List<Integer> integers = new ArrayList<Integer>() {
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
            integers.clear();
            integers.addAll(Arrays.asList(matrix[i]));
            System.out.println(integers);
        }
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
