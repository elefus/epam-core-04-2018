package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Realisation implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> linesIn = new ArrayList<>();
        String curr;
        try (BufferedReader reader = new BufferedReader(new FileReader(input)); BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            while ((curr = reader.readLine()) != null) {
                linesIn.add(curr);
            }
            for (int i = linesIn.size() - 1; i >= 0; i--) {
                writer.write(linesIn.get(i));
                writer.newLine();
            }
        }
        return linesIn;
    }
}
