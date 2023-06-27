package com.example.student.student;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService service;
    
    @GetMapping("/students")
    public ArrayList<Student> allStudents(){

        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student findStudent(@PathVariable int id){
        Student student = service.findStudent(id);
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return null;
    }

    
}
