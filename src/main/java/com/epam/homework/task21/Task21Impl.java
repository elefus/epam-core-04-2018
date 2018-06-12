package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        ArrayList<String> inputLines = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output)));
             BufferedReader reader = new BufferedReader(new FileReader(input))) {

            String line;
            while ((line = reader.readLine()) != null) {
                inputLines.add(line);
            }

            for (int i = inputLines.size() - 1; i >= 0; i--) {
                writer.println(inputLines.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputLines;
    }
}
