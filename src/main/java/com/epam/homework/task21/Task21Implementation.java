package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Implementation implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> listOfLines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {

            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                listOfLines.add(currentLine);
            }

            for (int i = listOfLines.size() - 1; i >= 0; i--) {
                bufferedWriter.println(listOfLines.get(i));
            }
        }
        return listOfLines;
    }

}
