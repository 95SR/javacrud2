package com.example.student.student;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public StudentsResponse allStudents(){
        ArrayList<Student> studentList = service.getAllStudents();
        StudentsResponse response = new StudentsResponse();
        if (studentList != null){
            response.setData(studentList);
            
        } else {
            response.setStatus(404);
            response.setSuccess(false);
            response.setData(null);
        }

        return response;
    }

    @GetMapping("/student/{id}")
    public StudentResponse findStudent(@PathVariable int id){
        Student student = service.findStudent(id);
        StudentResponse response = new StudentResponse();

        if (student != null){
            response.setData(student);
        } else{
            response.setStatus(404);
            response.setSuccess(false);
            response.setData(null);
        }
        
        return response;
    }

    @PostMapping("/students")
    public StudentResponse addStudent(@RequestBody Student student){
        Student newStudent = service.addStudent(student);
        System.out.println("controller:" + newStudent);
        StudentResponse response = new StudentResponse();

        if (newStudent != null){
            response.setData(newStudent);
        }else{
            response.setStatus(101);
            response.setSuccess(false);
            response.setData(null);
        }
        
        return response;
    }

    @DeleteMapping("/student/{id}")
    public BoolResponse removeStudent(@PathVariable int id){
        System.out.println("controller:" + id);
        boolean deleted = service.removeStudent(id);
        BoolResponse response = new BoolResponse();
        if(deleted){
            response.setData(deleted);
        } else {
            response.setSuccess(false);
            
        }
        

        return response;
    }

    
}
