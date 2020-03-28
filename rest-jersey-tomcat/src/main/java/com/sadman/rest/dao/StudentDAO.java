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
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        session.close();
        return students;
    }

    public void deleteStudent(String userName) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Student where userName = :userName";
        Query query = session.createQuery(hql);
        query.setString("userName",userName);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
    }

    public Student getStudent(String userName) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Student where userName = :userName");
        query.setString("userName",userName);
        Student student = (Student) query.list().get(0);
        tx.commit();
        session.close();
        return student;
    }

    public void updateStudent(String userName, Student student){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Student set firstName = :firstName, lastName=:lastName, password=:password where userName = :userName";
        Query query = session.createQuery(hql);
        query.setString("userName",userName);
        query.setString("firstName",student.getFirstName());
        query.setString("lastName",student.getLastName());
        query.setString("password",student.getPassword());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
    }
}
