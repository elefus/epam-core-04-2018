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

        Deque<Character> deque = new ArrayDeque<>();
        
        Set<Character> set1 = new HashSet<>(Arrays.asList('(','{','['));
        Set<Character> set2 = new HashSet<>(Arrays.asList(')','}',']'));

        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');


        for (char ch : string.toCharArray()) {

            if (set1.contains(ch)){
                deque.add(map.get(ch));
                continue;
            }

            if (set2.contains(ch)) {
                if (!deque.isEmpty() && deque.getLast() == ch) {
                    deque.removeLast();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}