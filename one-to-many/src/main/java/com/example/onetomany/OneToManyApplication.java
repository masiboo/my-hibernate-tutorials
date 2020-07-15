package com.example.onetomany;

import com.example.onetomany.service.DepartmentService;
import com.example.onetomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        Student student = new Student();
        student.setMobile(123456);
        student.setName("masum");

        Student student2 = new Student();
        student2.setMobile(202020);
        student2.setName("mahi");

        Department department = new Department();
        department.setName("BRTC");
        student.setDepartment(department);
        student2.setDepartment(department);
        //department.setStudentList(Arrays.asList(student, student2));
        //departmentService.saveDepartment(department);

        studentService.saveStudent(Arrays.asList(student, student2));*/

    }
}
