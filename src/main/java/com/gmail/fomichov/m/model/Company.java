package com.gmail.fomichov.m.model;

import java.util.List;

public class Company {
    private Long id;
    private String company;
    private List<Project> projectList;

    public Company() {
    }

    public Company(Long id, String company, List<Project> projectList) {
        this.id = id;
        this.company = company;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company withId(Long id) {
        this.id = id;
        return this;
    }


    public String getCompany() {
        return company;
    }

    public void setCompani(String compani) {
        this.company = company;
    }

    public Company withCompany(String company) {
        this.company = company;
        return this;
    }


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Company withProjectList(List<Project> projectList) {
        this.projectList = projectList;
        return this;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
