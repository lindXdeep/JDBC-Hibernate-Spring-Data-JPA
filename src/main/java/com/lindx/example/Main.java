package com.lindx.example;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.lindx.example.entity.Address;
import com.lindx.example.entity.Employee;
import com.lindx.example.entity.Project;

import com.lindx.service.AddressService;
import com.lindx.service.EmployeeService;
import com.lindx.service.ProjectService;
public class Main {

    public static void main(String[] args) throws SQLException {

        Address address = new Address();
                address.setCountry("DC");
                address.setCity("Gotham City");
                address.setStreet("Arkham street 1");
                address.setPostcode("0987");

        Address address2 = new Address();
                address2.setCountry("DC2");
                address2.setCity("other City");
                address2.setStreet("Red street 1");
                address2.setPostcode("8888");   
        
        Employee employee = new Employee();
                employee.setFirstname("James");
                employee.setLastname("Gordon");
        
        Employee employee2 = new Employee();
                employee2.setFirstname("Brawn");
                employee2.setLastname("Qwerty");

        Calendar calendar = Calendar.getInstance();
                calendar.set(1939, Calendar.MAY, 1);

                employee.setBirthday(new Date(calendar.getTime().getTime()));
                employee.setAddress(address);

        Project project = new Project();
              project.setTitle("5678");
        
        Project project2 = new Project();
              project.setTitle("1234");

        Set<Project> projects = new HashSet<>();
                projects.add(project);
                employee.setProjects(projects);

        new AddressService().add(address);
        new AddressService().add(address2);
        new AddressService().getAll().stream().forEach(System.out::println);
        new AddressService().getById(11L).toString().lines().forEach(System.out::println);
        new AddressService().update(address);
        new AddressService().remove(address2);

        new EmployeeService().add(employee);
        new EmployeeService().add(employee2);
        new EmployeeService().getAll().stream().forEach(System.out::println);
        new EmployeeService().getById(10L).toString().lines().forEach(System.out::println);
        new EmployeeService().update(employee);
        new EmployeeService().remove(employee2);

        new ProjectService().add(project);
        new ProjectService().add(project2);
        new ProjectService().getAll().stream().forEach(System.out::println);
        new ProjectService().getById(10L).toString().lines().forEach(System.out::println);
        new ProjectService().update(project);
        new ProjectService().remove(project2);
    }
}