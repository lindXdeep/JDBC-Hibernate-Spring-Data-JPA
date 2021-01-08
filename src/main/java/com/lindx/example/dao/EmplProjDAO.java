package com.lindx.example.dao;

import java.util.List;

import com.lindx.example.entity.EmplProj;

public interface EmplProjDAO {
    
    void add(EmplProj emplproj);
    void update(EmplProj emplproj);
    Void remove(EmplProj emplproj);

    EmplProj getByEmplProjId(Long id);
    
    List<EmplProj> getAll();
}