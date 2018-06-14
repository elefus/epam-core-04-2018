package com.epam.homework;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int words = Integer.parseInt(scanner.nextLine());
        boolean t = false;
        next:  for (int i = 0; i < words; i++) {
            String word = scanner.next().toLowerCase();
            if (word.length() == 1) continue next;

            else {
                int counter = 0;
                for (int y = 0; y < word.length()-1; y++) {
                    if (word.charAt(y) >= word.charAt(y+1)) {
                        continue next;
                    }
                    else {
                        counter++;
                    }
                }
                if (word.length()-1 == counter) {
                    System.out.println(word);
                    t = true;
                    break;
                }
            }
        }
        if (!t) {
            System.out.println("NOT FOUND");
        }
    }
}