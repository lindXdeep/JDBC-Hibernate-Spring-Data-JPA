package com.lindx.example.util;

import java.util.Properties;

import com.lindx.example.entity.Address;
import com.lindx.example.entity.Employee;
import com.lindx.example.entity.Project;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

    private static Properties properties = null;
    private static Configuration cfg = null;
    private static SessionFactory sessionFactory = null;

    static {
        properties = new Properties();
        properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/test1?autoReconnect=true&amp;useSSL=false");
        properties.setProperty(Environment.USER, "lindx");
        properties.setProperty(Environment.PASS, "MySql12345!");
        properties.setProperty(Environment.POOL_SIZE, "1");
        properties.setProperty(Environment.AUTOCOMMIT, "false");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.setProperty(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.NoCacheProvider");
        properties.setProperty(Environment.SHOW_SQL, "true");

        cfg = new Configuration();
        cfg.setProperties(properties);
        
        cfg.addAnnotatedClass(Address.class);
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Project.class);

        sessionFactory = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {

        try {
            return cfg.buildSessionFactory();
        }catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}