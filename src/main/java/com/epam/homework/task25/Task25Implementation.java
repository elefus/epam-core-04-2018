package com.epam.homework.task25;

import java.util.*;

public class Task25Implementation implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {

        Deque<Character> brackets = new ArrayDeque<>();

        List<Character> openBrackets = Arrays.asList('(', '{', '[');
        List<Character> closeBrackets = Arrays.asList(')', '}', ']');

        for (int i = 0; i < string.length(); i++) {

            if (openBrackets.contains(string.charAt(i))) {
                brackets.push(string.charAt(i));

            } else if (closeBrackets.contains(string.charAt(i))) {
                if (brackets.isEmpty()
                        || brackets.pop() != openBrackets.get(closeBrackets.indexOf(string.charAt(i)))) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
