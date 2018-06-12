package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task21Impl implements Task21 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     *
     * @param input  Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        ArrayList<String> inputLines = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output)));
             BufferedReader reader = new BufferedReader(new FileReader(input))) {

            String line;
            while ((line = reader.readLine()) != null) {
                inputLines.add(line);
            }

            for (int i = inputLines.size() - 1; i > 0; i--) {
                writer.println(inputLines.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputLines;
    }
}
