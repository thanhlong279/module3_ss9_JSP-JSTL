package com.example.demo.dto;

public class StudentDTO {
    private Long id;
    private String name;
    private String address;
    private Float point;
    private String nameClass;
    private Long id_class;

public StudentDTO(){}

    public StudentDTO(Long id, String address, Long id_class, String name, String nameClass, Float point) {
        this.id = id;
        this.address = address;
        this.id_class = id_class;
        this.name = name;
        this.nameClass = nameClass;
        this.point = point;
    }

    public StudentDTO(String address, Long id, String name, String nameClass, Float point) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.nameClass = nameClass;
        this.point = point;
    }

    public StudentDTO(long id, String name, String address, Float point, String nameClass) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.point = point;
    this.nameClass = nameClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }
}
