package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
            Collections.reverse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (String lines : result) {
                writer.write(lines);
                writer.newLine();
            }
            Collections.reverse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        String separator = File.separator;
        String path = separator+ "home"+ separator+ "heydancer"+separator+ "Рабочий стол"+separator+ "input";
        String path2 = separator+ "home"+ separator+ "heydancer"+separator+ "Рабочий стол"+separator+ "output";

        Task21Imp task21Imp = new Task21Imp();
        task21Imp.reverseFile(new File(path), new File(path2));
    }
}

