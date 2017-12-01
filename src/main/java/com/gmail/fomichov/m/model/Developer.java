package com.gmail.fomichov.m.model;

import java.math.BigDecimal;
import java.util.List;

public class Developer {
    private Long id;
    private String name;
    private BigDecimal salary;
    private List<Skill> skillList;
    private List<Project> projectList;

    public Developer() {
    }

    public Developer(Long id, String name, BigDecimal salary, List<Skill> skillList, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.skillList = skillList;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Developer withId(Long id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer withName(String name) {
        this.name = name;
        return this;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Developer withSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }


    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public Developer withListSkill(List<Skill> skillList) {
        this.skillList = skillList;
        return this;
    }


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Developer withListProject(List<Project> projectList) {
        this.projectList = projectList;
        return this;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", skillList=" + skillList +
                ", projectList=" + projectList +
                '}';
    }
}
