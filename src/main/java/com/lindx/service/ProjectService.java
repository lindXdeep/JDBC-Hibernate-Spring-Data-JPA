package com.lindx.service;

import java.sql.SQLException;
import java.util.List;

import com.lindx.example.dao.ProjectDAO;
import com.lindx.example.entity.Project;
import com.lindx.example.util.SessionUtil;

import org.hibernate.query.Query;

public class ProjectService implements ProjectDAO {

    @Override
    public void add(Project project) throws SQLException {
        
        SessionUtil.openTransactionSession();

        SessionUtil.getSession().save(project);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public List<Project> getAll() throws SQLException {
       
        String sql = "SELECT * FROM PROJECT";

        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Project.class);

        List<Project> projects = query.list();

        SessionUtil.closeTransactionSession();

        return projects;
    }

    @Override
    public Project getById(Long id) throws SQLException {
        String sql = "SELECT * FROM PROJECT WHERE id = :id";
       
        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Project.class);
            query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        SessionUtil.closeTransactionSession();

        return project;
    }

    @Override
    public void update(Project project) throws SQLException {

        SessionUtil.openTransactionSession();

        SessionUtil.getSession().update(project);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {

        SessionUtil.openTransactionSession();

        SessionUtil.getSession().delete(project);

        SessionUtil.closeTransactionSession();
    }
    
}
