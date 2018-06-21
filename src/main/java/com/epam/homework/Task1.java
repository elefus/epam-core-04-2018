package com.epam.homework;
import com.sun.nio.sctp.SctpChannel;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String minString = "";
        String maxString = "";
        int minLength = 0;
        int maxLength = 0;


       int stringAmount = Integer.parseInt(scanner.nextLine());
       String stringArray[] = new String[stringAmount];

        for (int i = 0; i < stringAmount; ++i) {
            stringArray[i]=scanner.nextLine();
        }

        maxLength = stringArray[0].length();
        minLength = stringArray[0].length();
        minString = stringArray[0];
        maxString = stringArray[0];
        for (int i = 1; i < stringAmount; i++) {
            if (stringArray[i].length() <= minLength) {
                minLength = stringArray[i].length();
                minString = stringArray[i];
            }
            if (stringArray[i].length() >= maxLength) {
                maxLength = stringArray[i].length();
                maxString = stringArray[i];
            }
        }

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);

    }
}
