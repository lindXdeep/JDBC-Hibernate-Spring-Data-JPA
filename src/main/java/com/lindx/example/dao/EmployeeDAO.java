package com.lindx.example.dao;

import java.util.List;

import com.lindx.example.entity.Employee;

public interface EmployeeDAO {
    
    void add(Employee employee);
    void update(Employee employee);
    Void remove(Employee employee);

    Employee getByEmployeeId(Long id);
    
    List<Employee> getAll();
}