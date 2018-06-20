package com.epam.homework.task25;

import java.util.*;

public class Task25Impl implements Task25 {

    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            switch (character) {
                case '(':
                case '{':
                case '[':
                    brackets.push(character);
                    break;
                case ')':
                    if (!(brackets.peek() == '(')) {
                        return false;
                    }
                    brackets.pop();
                    break;
                case '}':
                    if (!(brackets.peek() == '{')) {
                        return false;
                    }
                    brackets.pop();
                    break;
                case ']':
                    if (!(brackets.peek() == '[')) {
                        return false;
                    }
                    brackets.pop();
                    break;
            }
        }

        return brackets.empty();
    }
}
