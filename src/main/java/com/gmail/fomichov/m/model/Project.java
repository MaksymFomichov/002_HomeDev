package com.gmail.fomichov.m.model;

import java.math.BigDecimal;

public class Project {
    private Long id;
    private BigDecimal cost;
    private String project;

    public Project() {
    }

    public Project(Long id, BigDecimal cost, String project) {
        this.id = id;
        this.cost = cost;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project withId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Project withCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Project withProject(String project) {
        this.project = project;
        return this;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", cost=" + cost +
                ", project='" + project + '\'' +
                '}';
    }
}
