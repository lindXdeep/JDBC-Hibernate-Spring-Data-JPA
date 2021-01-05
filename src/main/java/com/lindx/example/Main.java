package com.lindx.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.lindx.example.dao.AddressDAO;
import com.lindx.example.dao.EmployeeDAO;
import com.lindx.example.entity.Address;
import com.lindx.example.entity.Employee;
import com.lindx.example.service.AddressService;
import com.lindx.example.service.EmployeeService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.List;

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
            employeeTom.setAddressID(1L);

        EmployeeDAO employee = new EmployeeService();

        employee.add(employeeTom);
    }
}