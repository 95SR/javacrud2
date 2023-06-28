package com.example.student.student;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.util.ResourceUtils;

public class CsvReader {

    public static ArrayList<Student> studentData() {
        ArrayList<Student> csvdata = new ArrayList<>();

        try {

            File file;
            file = ResourceUtils.getFile("classpath:sample.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] headerSplit;
            HashMap<String,Integer> header_index = new HashMap<>();
            boolean isFirst = true;
            String[] lineSplit;
            while ((line = reader.readLine()) != null) {
                if (isFirst) {
                    System.out.println(line +"scvreader");
                    headerSplit = line.split(",");
                    for (int i = 0 ; i < headerSplit.length ; i++) {
                        header_index.put(headerSplit[i], i);
                    }
                    
                    isFirst = false;
                    continue;
                }
                lineSplit = line.split(",");
                System.out.println(line);

                Student student = new Student(Integer.parseInt(lineSplit[header_index.get("id")]));
                student.setName(lineSplit[header_index.get("이름")]);
                student.setSex(lineSplit[header_index.get("성별")]);
                student.setAge(Integer.parseInt(lineSplit[header_index.get("나이")]));
                student.setPhone(lineSplit[header_index.get("전화번호")]);
                student.setLocation(lineSplit[header_index.get("거주지역")]);

                csvdata.add(student);

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return csvdata;
    }
}
