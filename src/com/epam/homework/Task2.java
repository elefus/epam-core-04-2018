package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        String[] strings;
        try (Scanner scanner = new Scanner( System.in )) {
            int number = Integer.valueOf( scanner.nextLine() );
            strings = new String[number];

            for (int i = 0; i < number; i++) {
                strings[i] = scanner.nextLine();
            }
        }

        Arrays.sort( strings, Task2::compare );

        for (String current : strings) {
            System.out.println( "(" + current.length() + "): " + current );
        }
    }

    private static int compare(String s1, String s2) {
        if ( s1.length() == s2.length() )
            return s1.compareTo( s2 );
        return Integer.compare( s1.length(), s2.length() );
    }
}