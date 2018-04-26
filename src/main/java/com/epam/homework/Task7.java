package com.epam.homework;

import java.util.*;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     * <p>
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numbOfWords = in.nextInt();

        List<String> inputWords = new ArrayList<>();
        for (int i = 0; i < numbOfWords; i++) {
            inputWords.add(in.next());
        }

        Set<String> result = getWordsWithUniqueLetters(inputWords);

        for (String word : result) {
            System.out.print(word + " ");
        }

    }

    private static Set<String> getWordsWithUniqueLetters(List<String> words) {
        Set<String> result = new HashSet<>();

        for (String currentWord : words) {
            currentWord = currentWord.toLowerCase();

            Integer counterOfUniqueLetters = new HashSet(Arrays.asList(currentWord.split(""))).size();
            if (counterOfUniqueLetters == currentWord.length()) {
                result.add(currentWord);
            }
        }

        if (result.isEmpty())
            result.add("NOT FOUND");

        return result;
    }
}
