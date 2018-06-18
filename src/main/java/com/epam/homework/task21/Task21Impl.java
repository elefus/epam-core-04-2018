package com.epam.homework.task21;

import java.io.*;
import java.util.*;

public class Task21Impl implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        }
        Collections.reverse(strings);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }
        Collections.reverse(strings);
        return strings;
    }
}
