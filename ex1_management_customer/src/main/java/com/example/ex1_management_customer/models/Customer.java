package com.example.ex1_management_customer.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Customer {
    private int id;
    private String name;
    private LocalDate dob;
    private String address;
    private String img;

    public Customer() {}

    public Customer(int id, String name, LocalDate dob, String address, String img) {
        this.address = address;
        this.dob = dob;
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDobAsDate() {
        return Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

