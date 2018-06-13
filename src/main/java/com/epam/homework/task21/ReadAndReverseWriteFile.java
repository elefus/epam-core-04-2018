package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndReverseWriteFile implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output))){
            while (reader.ready()){
                list.add(reader.readLine());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i));
            }
        }
        return list;
    }

}
