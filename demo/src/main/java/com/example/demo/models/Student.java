package com.example.demo.models;

public class Student {

    private Long id;
    private String name;
    private String address;
    private Float point;
    private Long id_class;

    public Student(Long id, String name, String address, Float point, Long id_class) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.id_class = id_class;
    }

    public Student(String address, Long id, Long id_class, String name, Float point) {
        this.address = address;
        this.id = id;
        this.id_class = id_class;
        this.name = name;
        this.point = point;
    }

    public Student(String name, String address, Float point, Long id_class) {
        this.name = name;
        this.point = point;
        this.address = address;
        this.id_class = id_class;
    }

    public Student(Long id, String name, String address, Float point) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }
}
