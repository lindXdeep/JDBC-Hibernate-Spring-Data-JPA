package com.lindx.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lindx.example.dao.EmplProjDAO;
import com.lindx.example.entity.EmplProj;
import com.lindx.example.util.Util;

import java.sql.Statement;

public class EmplProjService implements EmplProjDAO {

    private Connection connection = Util.getConnection();

    @Override
    public void add(EmplProj emplproj) {


        String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
        String sql2 = "INSERT INTO Empl_Proj (employee_id, project_id)" + 
                        "VALUES(?,?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){

            Statement statement = connection.createStatement();
                statement.execute(sql1);

            preparedStatement.setLong(1, emplproj.getEmploeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());
      
            preparedStatement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EmplProj emplproj) {

        String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
        String sql2 = "UPDATE Empl_Proj SET employee_id=?, project_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){

            Statement statement = connection.createStatement();
                statement.execute(sql1);

            preparedStatement.setLong(1, emplproj.getEmploeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());

            preparedStatement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(EmplProj emplproj) {

        String sql = "DELETE FROM Empl_Proj WHERE employee_id=? AND project_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setLong(1, emplproj.getEmploeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmplProj getByEmplProjId(Long id) {

        EmplProj eProj = new EmplProj();

        String sql = "SELECT employee_id, project_id FROM Empl_Proj WHERE employee_id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                eProj.setEmploeeID(resultSet.getLong("employee_id"));
                eProj.setProjectID(resultSet.getLong("project_id"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eProj;
    }

    @Override
    public List<EmplProj> getAll() {

        List<EmplProj> emplProjs = new ArrayList<>();

        String sql = "SELECT employee_id, project_id FROM Empl_Proj";

        try (Statement statement = connection.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                EmplProj eProj = new EmplProj();
                    eProj.setEmploeeID(resultSet.getLong("employee_id"));
                    eProj.setProjectID(resultSet.getLong("project_id"));

                emplProjs.add(eProj);
            } 

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emplProjs;
    }
}