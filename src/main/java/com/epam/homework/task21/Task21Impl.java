package com.epam.homework.task21;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Task21Impl implements Task21 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> inputStrings;
        try (BufferedReader br = new BufferedReader(new FileReader(input));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {

            inputStrings = br.lines().collect(Collectors.toList());

            for (int i = inputStrings.size() - 1; i >= 0; i--) {
                pw.println(inputStrings.get(i));
            }
        }

        return inputStrings;
    }
}
