package com.lindx.example.entity;

import java.util.Objects;

public class Project {
    private Long id;
    private String title;

    public Project() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
           return true;
        if(o ==null || this.getClass() != o.getClass())
           return false;
    
        Project project = (Project) o;
    
        return Objects.equals(id, project.id) && 
                Objects.equals(title, project.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", title='" + title + "'" +
            "}";
    }
}
