package com.example.onetomany.service;

import com.example.onetomany.exception.NotFoundException;
import com.example.onetomany.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department findById(long id);
    public Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department findDepartment(String name) throws NotFoundException;
}
