package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task25Solution implements Task25 {
    @Override
    public boolean isNormalBrackets(String str) {
        Stack<Character> bracket = new Stack<>();
        Map<Character, Character> possibleBrackets = new HashMap<>();
        possibleBrackets.put('<', '>');
        possibleBrackets.put('{', '}');
        possibleBrackets.put('[', ']');
        possibleBrackets.put('(', ')');


        for (int i = 0; i < str.length(); i++) {
            if (possibleBrackets.containsKey(str.charAt(i))) {
                bracket.push(str.charAt(i));

            } else if (possibleBrackets.containsValue(str.charAt(i))) {
                if (!bracket.empty() && possibleBrackets.get(bracket.peek()).equals(str.charAt(i))) {
                    bracket.pop();
                } else return false;
            }
        }
        return bracket.empty();
    }
}