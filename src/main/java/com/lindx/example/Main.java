package com.lindx.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
public class Main {

    static Connection connection = null;
    static Statement statement = null;
    public static void main(String[] args) {
        
        Address addressUSA = new Address();
            addressUSA.setId(1L);
            addressUSA.setCountry("USA");
            addressUSA.setCity("California");
            addressUSA.setStreet("Stars");
            addressUSA.setPostCode("123-456-789");

        Address addressRU = new Address();
            addressRU.setId(1L);
            addressRU.setCountry("Russia");
            addressRU.setCity("Spb");
            addressRU.setStreet("asdf");
            addressRU.setPostCode("321-456-789");
        
        AddressDAO address = new AddressService();

        address.add(addressUSA);

        address.getAll().stream().forEach(System.out::println);

        address.getByAddressId(addressUSA.getId()).toString().lines().forEach(System.out::println);

        address.update(addressRU);
        address.getByAddressId(addressRU.getId()).toString().lines().forEach(System.out::println);

        address.remove(addressRU);

    

        Employee employeeTom = new Employee();
            employeeTom.setId(1L);
            employeeTom.setFirstname("Tom");
            employeeTom.setLastname("Johnson");
            employeeTom.setBirthday(new Date(19880631));
            employeeTom.setAddressID(10L);

        Employee employeeBob = new Employee();
            employeeBob.setId(1L);
            employeeBob.setFirstname("Bob");
            employeeBob.setLastname("Smith");
            employeeBob.setBirthday(new Date(19980130));
            employeeBob.setAddressID(10L);

        EmployeeDAO employees = new EmployeeService();

        employees.add(employeeTom);

        employees.getAll().forEach(System.out::println);
    
        employees.update(employeeBob);
        employees.getByEmployeeId(employeeBob.getId()).toString().lines().forEach(System.out::println);
        employees.getAll().forEach(System.out::println);

        employees.remove(employeeBob);



        Project projectTest = new Project();
            projectTest.setId(10L);
            projectTest.setTitle("Test");
        
        Project projectRun = new Project();
            projectRun.setId(10L);
            projectRun.setTitle("Runnable");

        ProjectDAO projects = new ProjectService();

        projects.add(projectTest);

       
        projects.getProjects().stream().forEach(System.out::println);

        projects.update(projectRun);

        projects.getByProjectId(projectRun.getId()).toString().lines().forEach(System.out::print);

        projects.remove(projectRun);

        EmplProj eProj = new EmplProj();
            eProj.setEmploeeID(employeeBob.getId());
            eProj.setProjectID(projectRun.getId());

        EmplProjDAO emplProj = new EmplProjService();

        emplProj.add(eProj);
        emplProj.getAll().stream().forEach(System.out::println);

        emplProj.update(eProj);

        emplProj.getByEmplProjId(eProj.getEmploeeID());

        emplProj.remove(eProj);


    }
}