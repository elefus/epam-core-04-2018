package com.epam.homework;

    /*
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     *
     * Выходные данные:
     * The is a
     */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {

    private static List<String> array;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        array = new ArrayList<>();

        int digit = Integer.parseInt(scanner.nextLine());

        next : for (int i = 0; i < digit; i++) {

            String word = scanner.next();
            if (word.length() == 1) {
                addToArray(word);
                continue;
            }
            for (int y = 0; y < word.length()-1; y++) {
                for (int z = y+1; z < word.length(); z++) {
                    char a = word.toLowerCase().charAt(z);
                    char b = word.toLowerCase().charAt(y);
                    if (a == b) continue next;
                }
            }
            addToArray(word);
        }
        if (array.isEmpty()) {
            System.out.print("NOT FOUND");
        }
        else {
            for (int i = 0; i < array.size(); i++) {
                String a = array.get(i);
                if (i == array.size()-1) {
                    System.out.print(a);
                } else {
                    System.out.print(a + " ");
                }
            }
        }
    }
    private static void addToArray(String a) {
        if (!array.contains(a)) {
            array.add(a);
        }
    }
}