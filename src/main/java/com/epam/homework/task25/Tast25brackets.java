package com.epam.homework.task25;

import java.util.*;

public class Task25brackets implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {

        Deque<Character> brackets = new ArrayDeque<>();
        List<Character> oBrackets = Arrays.asList('(', '{', '[');
        List<Character> cBrackets = Arrays.asList(')', '}', ']');

        for (int i = 0; i < string.length(); i++) {

            if (oBrackets.contains(string.charAt(i))) {
                brackets.push(string.charAt(i));

            } else if (cBrackets.contains(string.charAt(i))) {
                if (brackets.isEmpty() || brackets.pop() != oBrackets.get(cBrackets.indexOf(string.charAt(i)))) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}