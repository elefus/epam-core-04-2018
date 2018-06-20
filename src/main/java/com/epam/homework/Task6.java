package com.epam.homework;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: InputArr[i].charAt(i) < InputArr[i].charAt(i   * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     *
     * Выходные данные:
     * by
     *
     * ===================================================================================================
     *
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     *
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
            int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];
            next:  for (int i = 0; i < N; i++) {
                    InputArr[i] = scanner.next().toLowerCase();
                    if (InputArr[i].length() == 1) continue next;
                else {
                            int counter = 0;
                            for (int j = 0; j < InputArr[i].length()-1; j++) {
                                    if (InputArr[i].charAt(j) >= InputArr[i].charAt(j+1)) {
                                            continue next;
                                        }
                                    else {
                                            counter++;
                                        }
                                }
                            if (InputArr[i].length()-1 == counter) {
                                    System.out.println(InputArr[i]);
                                    break;
                                }
                                else {
                                System.out.println("NOT FOUND");
                                break;
                            }
                        }
                }

               }
}
