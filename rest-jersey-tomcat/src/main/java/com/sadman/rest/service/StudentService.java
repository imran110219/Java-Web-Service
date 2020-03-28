package com.sadman.rest.service;

import com.sadman.rest.dao.StudentDAO;
import com.sadman.rest.database.DatabaseClass;
import com.sadman.rest.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// https://gist.github.com/bluekvirus/29789fe8080e31d84f921241311e567d
public class StudentService {

    StudentDAO studentDAO = new StudentDAO();

    public List<Student> getAllStudents() {
        return studentDAO.getStudents();
    }

    public Student getStudent(String userName) {
        return studentDAO.getStudent(userName);
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
        if (!student.getUserName().isEmpty()) {
            studentDAO.updateStudent(student.getUserName(), student);
        }
    }

    public void deleteStudent(String userName) {
        studentDAO.deleteStudent(userName);
    }
}
