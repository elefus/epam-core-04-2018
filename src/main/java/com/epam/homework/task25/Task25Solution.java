package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> bracket = new Stack<>();
        Map<Character, Character> possibleBrackets = new HashMap<>();

        possibleBrackets.put('{', '}');
        possibleBrackets.put('(', ')');
        possibleBrackets.put('[', ']');
        possibleBrackets.put('<', '>');

        for (int i = 0; i < string.length(); i++) {
            if (possibleBrackets.containsKey(string.charAt(i))) {
                bracket.push(string.charAt(i));

            } else if (possibleBrackets.containsValue(string.charAt(i))) {
                if (!bracket.empty() && possibleBrackets.get(bracket.peek()).equals(string.charAt(i))) {
                    bracket.pop();
                } else return false;
            }
        }
        return bracket.empty();
    }
}