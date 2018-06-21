package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> bracketStack = new Stack<>();
        Map<Character, Character> possibleBrackets = new HashMap<>();
        possibleBrackets.put('(', ')');
        possibleBrackets.put('{', '}');
        possibleBrackets.put('[', ']');

        for (Character curChar: string.toCharArray()) {
            if(possibleBrackets.containsKey(curChar)){
                bracketStack.push(curChar);
            }
            else if(possibleBrackets.containsValue(curChar)){
                if(bracketStack.empty() || !curChar.equals(possibleBrackets.get(bracketStack.peek()))){
                    return false;
                }
                else {
                    bracketStack.pop();
                }
            }
        }
        return bracketStack.empty();
    }
}
