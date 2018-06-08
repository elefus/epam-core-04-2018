package com.epam.homework;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task7 {

    private static Set<String> wordSet;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int limit = scanner.nextInt();
            if (limit > 0) wordSet = new LinkedHashSet<>();
            for (int i = 0; i < limit; i++) {
                String word = scanner.next();
                if (word.length() < 2) {
                    if (canAdd(word)) {
                        wordSet.add(word);
                    }
                }
                else {
                    String lowWord = word.toLowerCase();
                    if (lowWord.chars().distinct().count() == lowWord.length()) {
                        if (canAdd(word)) {
                            wordSet.add(word);
                        }
                    }
                }
            }
            if (wordSet.isEmpty()) {
                System.out.println("NOT FOUND");
            }
            else {
                for (String word : wordSet) {
                    System.out.print(word + " ");
                }
            }
        }
    }

    private static boolean canAdd(String word) {
        for (String string : wordSet) {
            if (string.equalsIgnoreCase(word)) return false;
        }
        return true;
    }
}