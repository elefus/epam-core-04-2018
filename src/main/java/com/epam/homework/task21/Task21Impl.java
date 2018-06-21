package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {

            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                list.add(0, readLine);
            }

            for (String writeLine : list) {
                bufferedWriter.write(writeLine);
                bufferedWriter.newLine();
            }

        }

        Collections.reverse(list);
        return list;

    }

}
