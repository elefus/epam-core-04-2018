package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task21class implements Task21 {
    public static void main(String[] args) throws IOException {
        Task21 object = new Task21class();
        List<String> testFile = object.reverseFile(new File("task 21.txt"), new File("task 21revers.txt"));
    }

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> file = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {
            while (reader.ready()) {
                String readString = reader.readLine();
                file.add(readString);
        }
            for (int i=file.size()-1; i>-1; i--) {
                writer.println(file.get(i));
                }
        return file;
    }

}
}
