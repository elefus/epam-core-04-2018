package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Impl implements Task21 {
    public static void main(String[] args) throws IOException {
        File input = new File("in.txt");
        File output = new File("out.txt");
        Task21 task21 = new Task21Impl();
        task21.reverseFile(input, output);
    }

    public List<String> reverseFile(File input, File output) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            StringBuilder builder = new StringBuilder();
            List<String> strings = new ArrayList<>();

            String currentRow;
            while (reader.ready()) {
                currentRow = reader.readLine();
                builder.append(currentRow);
                builder.append("\n");
                strings.add(currentRow);
            }
            builder.setLength(builder.length() - 1);
            builder.reverse();
            writer.write(builder.toString());
            return strings;
        }
    }
}



