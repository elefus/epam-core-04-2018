package com.epam.homework.task25;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Task25Impl implements Task25 {

    @Override
    public boolean isNormalBrackets(String string) {
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        for (char c : string.toCharArray()) {
            switch (c) {
                case '<':
                    brackets.addFirst('<');
                    map.put('>', '<');
                    break;
                case '(':
                    brackets.addFirst('(');
                    map.put(')', '(');
                    break;
                case '{':
                    brackets.addFirst('{');
                    map.put('}', '{');
                    break;
                case '[':
                    brackets.addFirst('[');
                    map.put(']', '[');
                    break;
                case '>':
                    if (brackets.isEmpty()||(!brackets.poll().equals(map.get('>')))){
                        return false;
                    }
                    break;
                case ')':
                    if (brackets.isEmpty()||(!brackets.poll().equals(map.get(')')))){
                        return false;
                    }
                    break;
                case '}':
                    if (brackets.isEmpty()||(!brackets.poll().equals(map.get('}')))){
                        return false;
                    }
                    break;
                case ']':
                    if (brackets.isEmpty()||(!brackets.poll().equals(map.get(']')))){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

}


