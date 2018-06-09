package com.epam.homework.task21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        try (Scanner scanner = new Scanner(input);
             FileWriter writer = new FileWriter(output)
        ) {
            List<String> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line);
                result.add(line);
            }
            return result;
        }
    }
}
