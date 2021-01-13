package com.lindx.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.lindx.example.entity.Employee;

public interface EmployeeDAO {
    void add(Employee employee) throws SQLException;
    List<Employee> getAll() throws SQLException;
    Employee getById(Long id) throws SQLException;
    void update(Employee employee) throws SQLException;
    void remove(Employee employee) throws SQLException;
}
