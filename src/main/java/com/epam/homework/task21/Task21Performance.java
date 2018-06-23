package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Performance implements Task21 {
    public List<String> reverseFile(File input, File output) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            List<String> strings = new ArrayList<>();
            String currentString;
            while ((currentString = reader.readLine()) != null) {
                strings.add(currentString);
            }
            for (int i = strings.size() - 1; i >= 0; i--) {
                writer.write(strings.get(i));
                writer.newLine();
            }
            return strings;
        }
    }
}