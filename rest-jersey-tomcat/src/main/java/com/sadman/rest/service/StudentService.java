package com.sadman.rest.service;

import com.sadman.rest.database.DatabaseClass;
import com.sadman.rest.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {
    private Map<String, Student> students = DatabaseClass.getStudents();

    public StudentService() {
        students.put("sadman", new Student(1L, "sadman", "Sadman", "Sobhan"));
        students.put("shahjahan", new Student(2L, "shahjahan", "Shahjahan", "Shahed"));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    public Student getStudent(String userName) {
        return students.get(userName);
    }

    public Student addStudent(Student student) {
        student.setId(students.size() + 1);
        students.put(student.getUserName(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student.getUserName().isEmpty()) {
            return null;
        }
        students.put(student.getUserName(), student);
        return student;
    }

    public Student removeStudent(String userName) {
        return students.remove(userName);
    }
}
