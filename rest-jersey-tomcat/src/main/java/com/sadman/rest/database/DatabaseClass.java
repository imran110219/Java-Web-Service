package com.sadman.rest.database;

import com.sadman.rest.model.Student;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<String, Student> students = new HashMap<>();

    public static Map<String, Student> getStudents() {
        return students;
    }
}
