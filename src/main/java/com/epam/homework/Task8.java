package com.epam.homework;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfWords = Integer.parseInt(scanner.next());
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < amountOfWords; i++) {
            String word = scanner.next();
            if (isDigit(word) && isPalyndrome(word)) {
                if (!arr.contains(word)) arr.add(word);
            }
        }
        if (arr.size() == 1) {
            System.out.println(arr.get(0));
        } else if (arr.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(arr.get(1));
        }
    }
    public static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalyndrome(String str) {
        if (str.length() == 1) {
            return true;
        } else {
            StringBuilder strBiuld = new StringBuilder(str);
            if (!strBiuld.toString().equals(strBiuld.reverse().toString()))  return false;
        }
        return true;
    }
}

