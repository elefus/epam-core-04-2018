package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndReverseWriteFile implements Task21{
    @Override
    public List<String> reverseFile(File input, File output) throws IOException{
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output))){
            while (reader.ready()){
                list.add(reader.readLine());
            }
            for (String line : list) {
                writer.write(line);
            }
        }
        return list;
    }
}
