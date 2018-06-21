package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21Impl implements Task21 {
    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
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
            }
            bw.flush();
        }
        return list;
    }
}
