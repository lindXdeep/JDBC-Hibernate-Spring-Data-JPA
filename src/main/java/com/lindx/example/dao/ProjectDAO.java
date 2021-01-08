package com.lindx.example.dao;

import java.util.List;

import com.lindx.example.entity.Project;

public interface ProjectDAO {
    
    void add(Project project);
    void update(Project project);
    Void remove(Project project);

    Project getByProjectId(Long id);
    
    List<Project> getProject();
}