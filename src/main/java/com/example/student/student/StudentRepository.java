package com.example.student.student;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private ArrayList<Student> mydata;

    public StudentRepository() {
        mydata = CsvReader.studentData();
    }

    public ArrayList<Student> getAllStudents() {

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
            newStudent = student;
            
        }

        System.out.println("repository:" +newStudent);

        return newStudent;

    }
}
