package com.example.onetomany.controller;

import com.example.onetomany.model.Department;
import com.example.onetomany.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDept")
    public String saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return "Saved successfully...";
    }

    @RequestMapping(value = "/departmentList", method = RequestMethod.GET)
    public @ResponseBody
    List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Department getDepartmentById(@PathVariable(required = true) long id){
        Department  department = departmentService.findById(id);
        return department;

    }

}
