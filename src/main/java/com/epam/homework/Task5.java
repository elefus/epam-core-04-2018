package com.epam.homework;
import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        int countWordsWithSameNumVowelsAndConsonants = 0;
        for (int i = 0; i < counter; i++) {
            String words = scanner.next();
            if (isLatin(words)) {
                if (vowelsEqualseConsonants(words)) {
                    countWordsWithSameNumVowelsAndConsonants++;
                }
            }
        }
        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }

    private static boolean isLatin(String str) {
        return str.matches("[a-zA-Z]+");
    }

    private static boolean isVowels(char ch) {
        return "aeiouyAEIOUY".indexOf(ch) >= 0;
    }

    private static boolean vowelsEqualseConsonants(String str) {
        int nubmerOfVovels = 0;
        int numberOfConsonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowels(str.charAt(i))) {
                nubmerOfVovels++;
            }
            else numberOfConsonants++;
        }

        return (nubmerOfVovels==numberOfConsonants);
    }


}
