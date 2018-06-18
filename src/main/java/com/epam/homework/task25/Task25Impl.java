package com.epam.homework.task25;

import java.util.HashMap;
import java.util.Stack;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        for (char character : string.toCharArray()) {

            if (hashMap.keySet().contains(character)) {
                stack.push(character);
            } else if (hashMap.values().contains(character)) {
                if (!stack.empty() && hashMap.get(stack.peek()) == character) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
