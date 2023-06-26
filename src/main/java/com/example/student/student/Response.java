package com.example.student.student;

import java.util.ArrayList;

public class Response {
    private boolean success;
    private ArrayList<Student> data;

    public Response(){
        success = true;
    }


    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public ArrayList<Student> getData() {
        return data;
    }
    public void setData(ArrayList<Student> data) {
        this.data = data;
    }



    
    
}
