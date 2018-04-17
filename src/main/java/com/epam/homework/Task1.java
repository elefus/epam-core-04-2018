package com.epam.homework;

import java.util.Scanner;

public class Task1 {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int min = 0;
        String maxString = "";
        String minString = "";

        int counter = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < counter; i++) {
            String a = scanner.nextLine();
            if (i == 0) {
                min = a.length();
            }
            if (a.length() == max) {
                maxString = a;
            }
            if (a.length() == min) {
                minString = a;
            }
            if (a.length() > max) {max = a.length(); maxString = a;}
            if (a.length() < min) {min = a.length(); minString = a;}
        }
        System.out.println("MIN (" + min + "): " + minString);
        System.out.println("MAX (" + max + "): " + maxString);
    }
}
