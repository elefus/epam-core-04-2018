package com.epam.homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    private static List<String> array;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = Integer.valueOf(scanner.nextLine());
        array = new ArrayList<>();
        int middle = 0;
        for (int i = 0; i < counter; i++) {
            String a = scanner.nextLine();
            array.add(a);
            middle += a.length();
        }
        int m = middle/=array.size();
        System.out.println("AVERAGE (" + m + ")");
        for (String a : array) {
            if (a.length() < m) {
                System.out.println("(" + a.length() + "): " + a);
            }
        }
    }
}
