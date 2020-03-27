package com.sadman.rest.dao;

import com.sadman.rest.configuration.SessionUtil;
import com.sadman.rest.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Query;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    public List<Student> getStudents(){
        Session session = SessionUtil.getSession();
        List<Student> students = (List<Student>) session.createQuery("from Student").list();
        session.close();
        return students;
    }

    public void deleteStudent(String userName) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Student where userName = :userName";
        int rowCount = session.createQuery(hql).executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
    }

    public Student getStudent(String userName) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.createQuery("from Student where userName = :userName");
        session.save(student);
        tx.commit();
        session.close();
    }
}
