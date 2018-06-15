package com.epam.homework.task25;

import java.util.*;

public class Task25Impl implements Task25{

    static Set<Character> commonSet = new HashSet<>(Arrays.asList('(', ')', '[', ']', '{', '}'));
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (commonSet.contains(character)) {
                if (!stack.isEmpty() && stack.peek() == map.get(character)) {
                    stack.pop();
                } else {
                    stack.add(character);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new Task25Impl().isNormalBrackets("212(2121)[]{");
    }
}
