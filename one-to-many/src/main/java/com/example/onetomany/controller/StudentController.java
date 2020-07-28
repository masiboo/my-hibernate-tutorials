package com.example.onetomany.controller;

import com.example.onetomany.exception.NotFoundException;
import com.example.onetomany.model.Department;
import com.example.onetomany.model.Student;
import com.example.onetomany.service.DepartmentService;
import com.example.onetomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/saveStudent/{deptName}")
    public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName){
        try {
            Department dept = departmentService.findDepartment(deptName.toUpperCase());

            for(Student student: studentList)
                student.setDepartment(dept);

            studentService.saveStudent(studentList);
            return "Student saved successfully..";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error in saving Student ..";
        }
    }

    @PostMapping("/save")
    public Student saveOne(@RequestBody Student student) throws NotFoundException {
        //Department dept = departmentService.findDepartment(student.getDepartment().getName());
        Student savedStudent = studentService.saveOne(student);
        return savedStudent;
    }
}
