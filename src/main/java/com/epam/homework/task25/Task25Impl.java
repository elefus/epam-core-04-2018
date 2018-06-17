package com.epam.homework.task25;

import java.util.*;

public class Task25Impl implements Task25 {

    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                brackets.push(character);
            } else if (character == ')') {
                if (brackets.peek() == '(') {
                    brackets.pop();
                }
            } else if (character == '}') {
                if (brackets.peek() == '{') {
                    brackets.pop();
                }
            } else if (character == ']') {
                if (brackets.peek() == '[') {
                    brackets.pop();
                }
            }
        }

        return brackets.empty();
    }
}
