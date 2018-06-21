package com.epam.homework;

import java.util.*;

public class Task2 {

    /**
     * Ввести N строк с консоли.
     * Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должны быть выведены N строк следующего вида:
     * (длина строки): строка наименьшей длины
     * (длина строки): строка большей длины
     * (длина строки): строка большей длины
     * ...
     * (длина строки): строка наибольшей длины
     * <p>
     * ----------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Тихо струится река серебристая
     * В царстве вечернем зеленой весны.
     * Солнце садится за горы лесистые.
     * Рог золотой выплывает луны.
     * <p>
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = scanner.nextLine();
            stringList.add(temp);
        }
        List<String> sortedStringList = getSortedList(stringList);

        for (String current : sortedStringList) {
            System.out.println("(" + current.length() + "): " + current);
        }
    }

    private static List<String> getSortedList(List<String> stringList) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int x = 0; x < stringList.size() - 1; x++) {
                String currentEntry = stringList.get(x);
                String currentEntryPlusOne = stringList.get(x + 1);

                if (isLonger(currentEntry, currentEntryPlusOne) ||
                        isIncorrectLexicographicalOrder(currentEntry, currentEntryPlusOne)) {
                    isSorted = false;
                    stringList.set(x, currentEntryPlusOne);
                    stringList.set(x + 1, currentEntry);
                }
            }
        }
        return stringList;
    }

    private static boolean isIncorrectLexicographicalOrder(String currentEntry, String currentEntryPlusOne) {
        if (currentEntry.length() == currentEntryPlusOne.length()) {
            int compareNum = currentEntry.compareToIgnoreCase(currentEntryPlusOne);
            return compareNum > 0;
        } else return false;
    }

    private static boolean isLonger(String currentEntry, String currentEntryPlusOne) {
        return currentEntry.length() > currentEntryPlusOne.length();
    }
}




