package com.epam.homework.task21;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> inputStrings;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             PrintWriter printWriter= new PrintWriter(new BufferedWriter(new FileWriter(output)))) {

            inputStrings = bufferedReader.lines().collect(Collectors.toList());

            for (int i = inputStrings.size() - 1; i >= 0; i--) {
                printWriter.println(inputStrings.get(i));
            }
        }
        return inputStrings;
    }
}
