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

            List<String> strings = new ArrayList<>();

            String currentRow;
            while ((currentRow = reader.readLine()) != null) {
                strings.add(currentRow);
            }
            System.out.println(strings.size());
            for (int i = strings.size() - 1; i >= 0; i--) {
                writer.write(strings.get(i));
                writer.newLine();
            }

            return strings;
        }
    }
}



