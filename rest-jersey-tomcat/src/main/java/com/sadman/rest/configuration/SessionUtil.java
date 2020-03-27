package com.sadman.rest.configuration;

import com.sadman.rest.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class SessionUtil {
    private static SessionUtil instance=new SessionUtil();
    private SessionFactory sessionFactory;

    public static SessionUtil getInstance(){
        return instance;
    }

    private SessionUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/restdb");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "12345678");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.FORMAT_SQL, "true");

//        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();

        return session;
    }
}
