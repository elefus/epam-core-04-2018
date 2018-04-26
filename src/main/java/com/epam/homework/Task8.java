package com.epam.homework;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     *
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countsOfWord = in.nextInt();

        List<String> inputWords = new ArrayList<>();
        for (int i = 0; i < countsOfWord; i++) {
            inputWords.add(in.next());
        }

        System.out.println(printTheSecondPalindromeOfNumber(inputWords, 1));
    }

    private static String printTheSecondPalindromeOfNumber(List<String> words, int wordOrder){
        List<String> palindromeNumbers = new ArrayList<>();

        for (String currentWord : words) {

            if (isNumber(currentWord)) {
                StringBuilder reverseWord = new StringBuilder(currentWord).reverse();

                if (currentWord.equals(reverseWord.toString())) {
                    palindromeNumbers.add(currentWord);

                    if(palindromeNumbers.size() == wordOrder + 1){
                        break;
                    }
                }
            }
        }

        if(palindromeNumbers.isEmpty()){
            return "NOT FOUND";
        }else if(palindromeNumbers.size() <= wordOrder){
            return palindromeNumbers.get(0);
        }else {
            return palindromeNumbers.get(wordOrder);
        }
    }

    private final static Set<Character> numbers = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9','0'));
    private static boolean isNumber(String word){

        for (int i = 0; i < word.length(); i++) {
            if(!numbers.contains(word.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
