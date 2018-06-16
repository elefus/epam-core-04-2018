package com.epam.homework.task25;

import java.util.*;

public class Task25Impl implements Task25 {

    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     * 1) Каждой открывающей скобке соответствует закрывающая того же типа.
     * 2) Нет пересечения областей, обрамленных скобками.
     *
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    @Override
    public boolean isNormalBrackets(String string) {

        Deque<Character> brackets = new ArrayDeque<>();

        char lastBracket = 0;
        for (int i = 0; i < string.length(); i++) {

            switch (string.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    if (lastBracket != 0) {
                        brackets.add(lastBracket);
                    }
                    lastBracket = string.charAt(i);
                    break;

                case ')':
                case ']':
                case '}':
                    if (lastBracket == getOpeningBracket(string.charAt(i))) {
                        lastBracket = brackets.isEmpty() ? 0 : brackets.pollLast();
                    } else {
                        return false;
                    }
            }
        }

        return lastBracket == 0;
    }

    private char getOpeningBracket(char bracket) {
        switch (bracket) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new IllegalArgumentException("Argument is not a closing bracket");
        }
    }
}
