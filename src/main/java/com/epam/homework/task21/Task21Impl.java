package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(input)); BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            String cur;
            while((cur = br.readLine())!= null){
                list.add(cur);
            }
            for (int i = list.size()-1; i >= 0; i--) {
                bw.write(list.get(i));
                bw.newLine();
            }
            bw.flush();
        }
        return list;
    }
}
