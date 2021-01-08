package com.lindx.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lindx.example.dao.EmployeeDAO;
import com.lindx.example.entity.Employee;
import com.lindx.example.util.Util;

public class EmployeeService implements EmployeeDAO {

    private Connection connection = Util.getConnection();

    @Override
    public void add(Employee employee) {
        
        String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
        String sql2 = "INSERT INTO Employee (id, first_name, last_name, birthday, address_id)" + 
                        "VALUES(?,?,?,?,?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){

            Statement statement = connection.createStatement();
                statement.execute(sql1);

            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstname());
            preparedStatement.setString(3, employee.getLastname());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setLong(5, employee.getAddressID());
       
            preparedStatement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        
        String sql1 = " SET FOREIGN_KEY_CHECKS=0;";
        String sql2 = "UPDATE Employee SET first_name=?, last_name=?, birthday=?, address_id=? WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){
            
            Statement statement = connection.createStatement();
            statement.execute(sql1);

            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressID());

            preparedStatement.setLong(5, employee.getId());
 
            preparedStatement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Employee employee) {

        String sql = "DELETE FROM Employee WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getByEmployeeId(Long id) {
       
        Employee employee = new Employee();

        String sql = "SELECT id, first_name, last_name, birthday, address_id FROM Employee WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                employee.setId(resultSet.getLong("id"));
                employee.setFirstname(resultSet.getString("first_name"));
                employee.setLastname(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressID(resultSet.getLong("address_id"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT id, first_name, last_name, birthday, address_id FROM Employee;";

        try (Statement statement = connection.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee = new Employee();
                    employee.setId(resultSet.getLong("id"));
                    employee.setFirstname(resultSet.getString("first_name"));
                    employee.setLastname(resultSet.getString("last_name"));
                    employee.setBirthday(resultSet.getDate("birthday"));
                    employee.setAddressID(resultSet.getLong("address_id"));

                employees.add(employee);
            } 

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}