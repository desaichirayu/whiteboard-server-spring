package com.example.cs5610su19javaservercdesai.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String owner;
    private String modified;

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<Module> modules;

    public void set(Course newCourse){
        this.title = newCourse.getTitle();
        this.owner = newCourse.getOwner();
        this.modified = newCourse.getModified();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                ", modified='" + modified + '\'' +
                ", modules=" + modules +
                '}';
    }
}
