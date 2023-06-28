package com.example.student.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.util.ResourceUtils;

public class CsvWriter {

    public static void studentData(Student student) {
        System.out.println("try to write");
        File file;
        try {
            String fileName = "src/main/resources/sample.csv";
            // file = ResourceUtils.getFile("classpath:sample.csv");
            FileWriter writer = new FileWriter(fileName, true);
            String toCsv = "";
            int id = student.getId();
            String name = student.getName();
            String sex = student.getSex();
            int age = student.getAge();
            String phone = student.getPhone();
            String location = student.getLocation();

            toCsv += "\n" + id + "," + name + "," + sex + "," + age + "," + phone + "," + location;

            writer.write(toCsv);
            writer.flush();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void removeStudent(int id) {
      
        File file;
        try {
            file = ResourceUtils.getFile("classpath:sample2.csv");
           
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter(file, true);
        String line;
        String idStr;
        String studentId;
        while(true){
            line = reader.readLine();
            idStr = String.valueOf(id);
            studentId = String.valueOf(line.charAt(0));
            if(studentId.equals(idStr)){
                System.out.println(line);
                
                
                break;
            }
            
        }
        writer.flush();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
    }

}
