package com.example.onetomany.service;


import com.example.onetomany.model.Student;

import java.util.List;

public interface StudentService {

    public void saveStudent(List<Student> studentList);

    public List<Student> getStudents();

}