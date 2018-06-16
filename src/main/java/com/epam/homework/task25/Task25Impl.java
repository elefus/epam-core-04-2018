package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> bracketState = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
        brackets.put('<', '>');

        for (int i = 0; i < string.length(); i++) {
                if (brackets.containsKey(string.charAt(i))){
                    bracketState.push(string.charAt(i));
                    continue;
                }

                if(!bracketState.empty() && brackets.get(bracketState.peek()).equals(string.charAt(i))){
                    bracketState.pop();
                }
        }
        return bracketState.empty();
    }
}
