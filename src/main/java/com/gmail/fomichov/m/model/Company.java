package com.gmail.fomichov.m.model;

public class Company {
    private Long id;
    private String company;

    public Company() {
    }

    public Company(Long id, String company) {
        this.id = id;
        this.company = company;
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", compani='" + company + '\'' +
                '}';
    }
}
