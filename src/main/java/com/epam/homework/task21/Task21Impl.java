package com.epam.homework.task21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        try (Scanner scanner = new Scanner(input);
             PrintWriter writer = new PrintWriter(output)
        ) {
            List<String> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.add(line);
            }

            for (int i = result.size() - 1; i >= 0 ; i--) {
                writer.println(result.get(i));
            }
            return result;
        }
    }


    public static void main(String[] args) throws IOException {
//        Task21 object = new Task21Impl();
//        String INPUT = "C:\\Users\\m-i-n\\IdeaProjects\\hw\\epam-core-04-2018\\src\\main\\java\\com\\epam\\homework\\task21\\input.txt";
//        String OUTPUT = "C:\\Users\\m-i-n\\IdeaProjects\\hw\\epam-core-04-2018\\src\\main\\java\\com\\epam\\homework\\task21\\output.txt";
//        List<String> result = object.reverseFile(new File(INPUT), new File(OUTPUT));
    }
}
