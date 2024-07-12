package com.example.firstjobapp.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Table(name="newJob")         //Customizing the table name
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //automatically generation of value
    private long id;
    private String name;
    private String description;
    private String title;
    private String minSalary;
    private String maxSalary;

    public Job() {
    }

    public Job(long id, String name, String description, String title, String minSalary, String maxSalary) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }
}
