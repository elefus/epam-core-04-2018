package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Impl implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> linesFromInput = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            String temp;

            while ((temp = reader.readLine()) != null) {
                linesFromInput.add(temp);
            }
            for (int i = linesFromInput.size() - 1; i >= 0; i--) {
                writer.write(linesFromInput.get(i));
                writer.newLine();
            }
        }
        return linesFromInput;
    }
}
