package com.lindx.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.lindx.example.entity.Address;
import com.lindx.example.entity.Employee;
import com.lindx.example.entity.Project;

import com.lindx.example.util.HibernateUtil;

import org.hibernate.Session;
public class Main {

    static Connection connection = null;
    static Statement statement = null;

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
                address.setCountry("DC");
                address.setCity("Gotham City");
                address.setStreet("Arkham street 1");
                address.setPostcode("0987");

        Employee employee = new Employee();
                employee.setFirstname("James");
                employee.setLastname("Gordon");

        Calendar calendar = Calendar.getInstance();
                calendar.set(1939, Calendar.MAY, 1);

                employee.setBirthday(new Date(calendar.getTime().getTime()));
                employee.setAddress(address);

        Project project = new Project();
        project.setTitle("5678");

        Set<Project> projects = new HashSet<>();
                    projects.add(project);
                employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        
        HibernateUtil.shutdown();
    }
}