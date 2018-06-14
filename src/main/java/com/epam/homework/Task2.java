package com.epam.homework;


import java.util.*;

public class Task2 {

    private static List<String> array;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counter = Integer.valueOf(scanner.nextLine());
        array = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            String a = scanner.nextLine();
            array.add(a);
        }
        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.length() - o2.length();
                if (i == 0) {
                    return o1.compareTo(o2);
                } else {
                    return i;
                }
            }
        });
        for (String a : array) {
            System.out.println("(" + a.length() + "): " + a);
        }
    }
}
