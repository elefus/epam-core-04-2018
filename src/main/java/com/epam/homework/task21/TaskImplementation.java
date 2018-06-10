package com.epam.homework.task21;

import java.io.*;
import java.util.*;

public class TaskImplementation implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> strings;
        try (FileInputStream inputStream = new FileInputStream(input)) {
            strings = new ArrayList<>();
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNextLine()) {
                    strings.add(scanner.nextLine());
                }
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(output)) {
            for (int i = strings.size()-1; i >= 0; i--) {
                outputStream.write(strings.get(i).getBytes());
            }
        }
        return strings;
    }
}