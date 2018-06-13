package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndReverseWriteFile implements Task21{
    @Override
    public List<String> reverseFile(File input, File output) throws IOException{
        List<String> reverseList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(input))){
            String line;
            while ((line = reader.readLine()) != null){
                reverseList.add(0, line);
            }
        }
        return reverseList;
    }
}
