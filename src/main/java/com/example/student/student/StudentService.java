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

    public Student addStudent(Student student){
        Student newStudent = repository.saveStudent(student);
        System.out.println("service:" +newStudent);

        return newStudent;
    }

    public boolean removeStudent(int id){
        boolean deleted = repository.removeStudent(id);

        return deleted;
    }

    public Student editStudent(Student student){
        Student editedStudent = repository.editStudent(student);

        return editedStudent;
    }
}
