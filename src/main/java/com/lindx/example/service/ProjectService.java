package com.lindx.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lindx.example.dao.ProjectDAO;
import com.lindx.example.entity.Project;
import com.lindx.example.util.Util;

public class ProjectService implements ProjectDAO {

    private Connection connection = Util.getConnection();

    @Override
    public void add(Project project) {

        String sql = "INSERT INTO Project (id, title)" + 
                        "VALUES(?,?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
      
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Project project) {

        String sql1 = " SET FOREIGN_KEY_CHECKS=0;";
        String sql2 = "UPDATE Project SET title=? WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){
            
            Statement statement = connection.createStatement();
                statement.execute(sql1);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());
 
            preparedStatement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Project project) {

        String sql = "DELETE FROM Project WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setLong(1, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getByProjectId(Long id) {

        Project project = new Project();

        String sql = "SELECT id, title FROM Project WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();

        String sql = "SELECT id, title FROM Project";

        try (Statement statement = connection.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Project project = new Project();
                    project.setId(resultSet.getLong("id"));
                    project.setTitle(resultSet.getString("title"));

                projects.add(project);
            } 

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
