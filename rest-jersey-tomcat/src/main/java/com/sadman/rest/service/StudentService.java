package com.sadman.rest.service;

import com.sadman.rest.dao.StudentDAO;
import com.sadman.rest.database.DatabaseClass;
import com.sadman.rest.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// https://gist.github.com/bluekvirus/29789fe8080e31d84f921241311e567d
public class StudentService {

    private StudentDAO studentDAO;
    private Map<String, Student> students = DatabaseClass.getStudents();

    public StudentService() {
        students.put("sadman", new Student(1L, "sadman", "Sadman", "Sobhan"));
        students.put("shahjahan", new Student(2L, "shahjahan", "Shahjahan", "Shahed"));
    }

    public List<Student> getAllStudents() {
        return studentDAO.getStudents();
    }

    public Student getStudent(String userName) {
        return studentDAO.getStudent(userName);
    }

    public Student addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student updateStudent(Student student) {
        if (student.getUserName().isEmpty()) {
            return null;
        }
        students.put(student.getUserName(), student);
        return student;
    }

    public void deleteStudent(String userName) {
        studentDAO.deleteStudent(userName);
    }
}
