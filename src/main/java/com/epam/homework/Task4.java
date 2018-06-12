package com.epam.homework;

import java.util.*;

public class Task4 {

    private static List<String> array;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = Integer.valueOf(scanner.nextLine());
        String s = scanner.nextLine();
        array = new ArrayList<>(Arrays.asList(s.split(" ")));
        int min = getDifferences(array.get(0));
        int minIndex = 0;
        for (int i = 1; i < array.size()-1; i++) {
            if (getDifferences(array.get(i)) < min ) {
                minIndex = i;
            }
            else if (getDifferences(array.get(i)) == min) {
                minIndex = minIndex > i ? i : minIndex;
            }
        }
        System.out.println(array.get(minIndex));
    }

    private static int getDifferences(String input) {
        int result = 0;
        for (int i = 0; i < input.length()-1; i++) {
            for (int y = i+1; y < input.length(); y++) {
                if (input.charAt(i) != input.charAt(y) ||
                        (input.charAt(i) == input.charAt(y) &&
                                (Character.isLowerCase(input.charAt(i)) && Character.isUpperCase(input.charAt(y)) ||
                                        Character.isLowerCase(input.charAt(y)) && Character.isUpperCase(input.charAt(i))))) {
                    result++;
                }
            }
        }
        return result;
    }
}
