package com.example.student.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

public class CsvReader {

   

    public static ArrayList<Student> csvData() {
        ArrayList<Student> csvdata= new ArrayList<>();

        try {
            
            File file;
            file = ResourceUtils.getFile("classpath:sample.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean isFirst = true;
            String[] lineSplit;
            while((line = reader.readLine())!= null){
                if(isFirst){
                    isFirst=false;
                    continue;
                }
                lineSplit= line.split(",");

                Student student = new Student(Integer.parseInt(lineSplit[0]));
            student.setName(lineSplit[1]);
            student.setSex(lineSplit[2]);
            student.setAge(Integer.parseInt(lineSplit[3]));
            student.setPhone(lineSplit[4]);
            student.setLocation(lineSplit[5]);

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
