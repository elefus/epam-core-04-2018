package com.epam.homework.task21;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        LinkedList<String> stringsFromFile = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                stringsFromFile.add(readLine);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))) {
            Iterator backwardsIterator = stringsFromFile.descendingIterator();
            while (backwardsIterator.hasNext()) {
                writer.write((String) backwardsIterator.next());
                writer.newLine();
            }
            writer.flush();
        }

        return stringsFromFile;
    }
}
