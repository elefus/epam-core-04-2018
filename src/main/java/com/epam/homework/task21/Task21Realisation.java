package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task21Realisation implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(input))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (int i = strings.size() - 1; i >= 0; i--) {
                writer.write(strings.get(i));
                writer.newLine();
            }
        }
        return strings;
    }
}
