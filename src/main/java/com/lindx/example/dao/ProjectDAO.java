package com.lindx.example.dao;

import java.util.List;

import com.lindx.example.entity.Project;

public interface ProjectDAO {
    
    void add(Project project);
    void update(Project project);
    void remove(Project project);

    Project getByProjectId(Long id);
    
    List<Project> getProjects();
}