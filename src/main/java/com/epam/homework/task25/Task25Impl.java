package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> bracketStack = new Stack<>();
        Map<Character, Character> possibleBrackets = new HashMap<>();

        possibleBrackets.put('{', '}');
        possibleBrackets.put('(', ')');
        possibleBrackets.put('[', ']');
        possibleBrackets.put('<', '>');

        for (int i = 0; i < string.length(); i++) {
            if (possibleBrackets.containsKey(string.charAt(i))) {
                bracketStack.push(string.charAt(i));

            } else if (possibleBrackets.containsValue(string.charAt(i))) {
                if (!bracketStack.empty() && possibleBrackets.get(bracketStack.peek()).equals(string.charAt(i))) {
                    bracketStack.pop();
                } else return false;
            }
        }
        return bracketStack.empty();
    }
}
