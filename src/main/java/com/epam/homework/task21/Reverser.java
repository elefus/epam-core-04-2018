package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reverser implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> lines = this.readLinesFrom(input);

        ArrayList<String> reversedLines = new ArrayList<>(lines);
        Collections.reverse(reversedLines);

        this.writeLinesTo(output, reversedLines);

        return lines;
    }

    private List<String> readLinesFrom(File input) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    private void writeLinesTo(File output, List<String> lines) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {
            for (String line: lines) {
                printWriter.println(line);
            }
        }
    }
}
