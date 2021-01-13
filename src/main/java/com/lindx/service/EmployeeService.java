package com.lindx.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;

import com.lindx.example.dao.EmployeeDAO;
import com.lindx.example.entity.Employee;
import com.lindx.example.util.SessionUtil;

public class EmployeeService implements EmployeeDAO {

    @Override
    public void add(Employee employee) throws SQLException {

        SessionUtil.openTransactionSession();

        SessionUtil.getSession().save(employee);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() throws SQLException {

        String sql = "SELECT * FROM EMPLOYEE";

        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Employee.class);
                
        List<Employee> employees = query.list();

        SessionUtil.closeTransactionSession();

        return employees;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
       
        String sql = "SELECT * FROM EMPLOYEE WHERE id = :id";
       
        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Employee.class);
            query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        SessionUtil.closeTransactionSession();

        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        
        SessionUtil.openTransactionSession();

        SessionUtil.getSession().update(employee);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Employee employee) throws SQLException {

        SessionUtil.openTransactionSession();

        SessionUtil.getSession().delete(employee);

        SessionUtil.closeTransactionSession();
    }
}