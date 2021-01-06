package com.lindx.example;

import com.lindx.example.dao.AddressDAO;
import com.lindx.example.dao.EmplProjDAO;
import com.lindx.example.dao.EmployeeDAO;
import com.lindx.example.dao.ProjectDAO;
import com.lindx.example.entity.Address;
import com.lindx.example.entity.EmplProj;
import com.lindx.example.entity.Employee;
import com.lindx.example.entity.Project;
import com.lindx.example.service.AddressService;
import com.lindx.example.service.EmplProjService;
import com.lindx.example.service.EmployeeService;
import com.lindx.example.service.ProjectService;

import org.hibernate.Session;

import bl.HibernateUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
                address.setPostCode("0987");

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