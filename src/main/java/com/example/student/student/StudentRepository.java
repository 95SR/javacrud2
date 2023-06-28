package com.example.student.student;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private ArrayList<Student> mydata;

    public StudentRepository() {
        mydata = CsvReader.studentData();
    }

    public ArrayList<Student> getAllStudents() {
        System.out.println(mydata);
        return mydata;
    }

    public Student findStudent(int id) {
        for (Student student : mydata) {
            int studentId = student.getId();
            if (studentId == id) {
                return student;
            }
        }

        return null;
    }

    public Student saveStudent(Student student) {
        Student newStudent = new Student();
        boolean duplicateId=false;
        for (Student item : mydata) {
            if (item.getId() == student.getId()) {
                newStudent = null;
                
                duplicateId=true;
                break;
            } 
        }

        if(!duplicateId){
            mydata.add(student);
            CsvWriter.studentData(student);
            newStudent = student;
            
        }

        System.out.println("repository:" +newStudent);

        return newStudent;

    }

    public boolean removeStudent(int id){
       
    boolean deleted=false;
       Predicate<Student> condition = student -> student.getId()==id;
       deleted = mydata.removeIf(condition);
        CsvWriter.removeStudent(id);
       


       return deleted;
    }
}
