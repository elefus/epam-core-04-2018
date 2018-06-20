package com.epam.homework.task25;

import java.util.*;

public class Task25class implements Task25 {

    @Override
    public boolean isNormalBrackets(String string) {
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('}', '{');
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        List<Character> brackets = new ArrayList<>();
        for (int i = 0; i<string.length(); i++) {
            if (string.charAt(i) == ')' || string.charAt(i) == '}' || string.charAt(i) == ']') {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (bracketsMap.get(string.charAt(i)) == brackets.get(brackets.size()-1)) {
                    brackets.remove(brackets.size()-1);
                }
                else return false;
            }
            if (string.charAt(i) == '(' || string.charAt(i) == '{' || string.charAt(i) == '[') {
                brackets.add(string.charAt(i));
            }
        }
        return brackets.isEmpty();
    }
}
