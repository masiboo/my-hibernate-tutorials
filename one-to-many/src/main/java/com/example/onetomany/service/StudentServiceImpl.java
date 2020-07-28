package com.example.onetomany.service;

import com.example.onetomany.dao.StudentRepository;
import com.example.onetomany.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public Student saveOne(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
