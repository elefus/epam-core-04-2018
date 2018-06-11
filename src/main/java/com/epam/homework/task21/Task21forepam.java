package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task21forepam implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
            Collections.reverse(result);
            for (String lines : result) {
                writer.write(lines);
                writer.newLine();
            }
            return result;
        }
    }
}
