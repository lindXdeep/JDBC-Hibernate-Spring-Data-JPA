package com.lindx.example.entity;

import java.util.Objects;

public class EmplProj {
    private Long emploeeID;
    private Long projectID;

    public EmplProj() {
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
           return true;
        if(o ==null || this.getClass() != o.getClass())
           return false;
    
        EmplProj emplproj = (EmplProj) o;
    
        return Objects.equals(emploeeID, emplproj.emploeeID) && 
               Objects.equals(projectID, emplproj.projectID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emploeeID, projectID);
    }

    @Override
    public String toString() {
        return "{" +
            " emploeeID='" + emploeeID + "'" +
            ", projectID='" + projectID + "'" +
            "}";
    }

    public Long getEmploeeID() {
        return this.emploeeID;
    }

    public void setEmploeeID(Long emploeeID) {
        this.emploeeID = emploeeID;
    }

    public Long getProjectID() {
        return this.projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
}