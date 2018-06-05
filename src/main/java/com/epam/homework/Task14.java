package com.epam.homework;

import java.util.*;

public class Task14 {

    /**
     * Найти количество элементов самой длинной строго возрастающей подпоследовательности.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * <a href="https://ru.wikipedia.org/wiki/Монотонная_последовательность">Строго возрастающая последовательность</a>
     * <p>
     * Формат входных данных:
     * N (целое число) - количество элементов исходной последовательности (0 < N < 100).
     * N целых чисел - элементы последовательности.
     * <p>
     * Формат выходных данных:
     * Число, отображающее количество элементов на самом большом возрастающем участке последовательности.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 8
     * 2 1 3 3 4 5 6 5
     * <p>
     * Выходные данные:
     * 4
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 6
     * 6 5 4 3 2 1
     * <p>
     * Выходные данные:
     * 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amountOfNumbers = sc.nextInt();


        int[] numbersFromInput = getNumbersFromInputToArray(sc, amountOfNumbers);

        System.out.println(findLengthOfMaxSequence(numbersFromInput));


    }

    private static int findLengthOfMaxSequence(int[] numbersFromInput) {
        int maxStrictlyRisingSequence = 0;
        int amountOfNumbers = numbersFromInput.length;
        int counter = 1;
        for (int i = 0; i < amountOfNumbers - 1; i++) {
            if (numbersFromInput[i + 1] - numbersFromInput[i] == 1) {
                counter++;
                if (maxStrictlyRisingSequence < counter) {
                    maxStrictlyRisingSequence = counter;
                }
            } else {
                counter = 1;
            }
        }
        return maxStrictlyRisingSequence <= 1 ? 0 : maxStrictlyRisingSequence;
    }

    private static int[] getNumbersFromInputToArray(Scanner sc, int arrayLength) {
        int[] numbersFromInput = new int[arrayLength];

        for (int j = 0; j < arrayLength; j++) {
            numbersFromInput[j] = sc.nextInt();
        }
        return numbersFromInput;
    }
}

