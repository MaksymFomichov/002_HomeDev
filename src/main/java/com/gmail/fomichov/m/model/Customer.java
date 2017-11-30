package com.gmail.fomichov.m.model;

public class Customer {
    private Long id;
    private String customer;

    public Customer() {
    }

    public Customer(Long id, String customer) {
        this.id = id;
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                '}';
    }
}
