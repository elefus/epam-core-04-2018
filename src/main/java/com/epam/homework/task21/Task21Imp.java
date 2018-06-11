package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Imp implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> result = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {

            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (String lines : result) {
                writer.write(lines);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}

