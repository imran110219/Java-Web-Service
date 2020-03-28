package com.sadman.rest;

import com.sadman.rest.configuration.SessionUtil;
import com.sadman.rest.dao.StudentDAO;
import com.sadman.rest.model.Student;
import com.sadman.rest.service.StudentService;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAllStudents();
        System.out.println(students.get(0).getUserName());
    }
}
