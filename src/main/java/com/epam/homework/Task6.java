package com.epam.homework;
import java.time.LocalDate;
import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     * <p>
     * Выходные данные:
     * by
     * <p>
     * ===================================================================================================
     * <p>
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     * <p>
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int wordCounter = in.nextInt();
        in.nextLine();


        String result = "NOT FOUND";

        for (int i = 0; i < wordCounter; i++) {
            String currentWord = in.next();

            if (currentWord.length() > 1) {
                String inLowerCase = currentWord.toLowerCase();
                boolean isAscendingOrder = true;

                for (int j = 0; j < inLowerCase.length() - 1; j++) {
                    if (inLowerCase.charAt(j) >= inLowerCase.charAt(j + 1)) {
                        isAscendingOrder = false;
                    }
                }
                if (isAscendingOrder) {
                    result = currentWord;
                }
            }
        }
        System.out.println(result);
    }
}
