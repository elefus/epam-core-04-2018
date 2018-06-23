package com.epam.homework.task21;

import java.io.*;
import java.util.*;

public class Task21reverser implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i));
                writer.newLine();
            }
        }
        return list;
    }
}