package com.example.onetomany.service;

import com.example.onetomany.dao.DepartmentRepository;
import com.example.onetomany.exception.NotFoundException;
import com.example.onetomany.model.Department;
import com.example.onetomany.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findById(long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }

    @Override
    @Transactional
    public Department saveDepartment(Department department) {
        List<Student> students =  department.getStudentList();
        students.forEach(st -> st.setDepartment(department));
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartment(String name) throws NotFoundException {
        //Optional<Department> d = departmentRepository.findDepartmentByName(name);
        Department d = departmentRepository.findDepartmentByName(name);
        //Department department = d.orElseThrow(() -> new NotFoundException("Not found"));
        //Department result = d.get();
        return d;
    }
}
