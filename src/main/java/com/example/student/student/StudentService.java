package com.example.student.student;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public ArrayList<Student> getAllStudents(){
        return repository.getAllStudents();
    }

    public Student findStudent(int id){
        return repository.findStudent(id);
    }
    
}
