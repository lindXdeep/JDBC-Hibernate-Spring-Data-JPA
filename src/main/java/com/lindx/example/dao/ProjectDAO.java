package com.lindx.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.lindx.example.entity.Project;

public interface ProjectDAO {
    void add(Project project) throws SQLException;
    List<Project> getAll() throws SQLException;
    Project getById(Long id) throws SQLException;
    void update(Project project) throws SQLException;
    void remove(Project project) throws SQLException;
}
