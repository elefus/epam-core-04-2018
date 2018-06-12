package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReverseFileClass implements Task21 {
    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     *
     * @param input  Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            while (reader.ready()) {
                list.add(reader.readLine());
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i));

                if (i > 0) {
                    writer.newLine();
                }
            }
        }
        return list;
    }
}
