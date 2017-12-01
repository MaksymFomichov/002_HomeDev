package com.gmail.fomichov.m.model;

import java.util.List;

public class Customer {
    private Long id;
    private String customer;
    private List<Project> projectList;

    public Customer() {
    }

    public Customer(Long id, String customer, List<Project> projectList) {
        this.id = id;
        this.customer = customer;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer withId(Long id) {
        this.id = id;
        return this;
    }


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Customer withCustomer(String customer) {
        this.customer = customer;
        return this;
    }


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Customer withProjectList(List<Project> projectList) {
        this.projectList = projectList;
        return this;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
