package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task21forepam implements Task21 {

    public static void main(String[] args) throws IOException {
//        String separator = File.separator;
//        String path1 = separator + "home" + separator + "heydancer" + separator + "Рабочий стол" + separator + "input";
//        String path2 = separator + "home" + separator + "heydancer" + separator + "Рабочий стол" + separator + "output";
//
//        Task21 task21 = new Task21forepam();
//        task21.reverseFile(new File(path1), new File(path2));
    }

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
                writer.write(lines + "\n");
            }
            return result;
        }
    }
}
