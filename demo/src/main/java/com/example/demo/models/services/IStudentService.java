package com.example.demo.models.services;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentService {
List<Student> findAll();

    void save(Student student);

    Boolean deleteByID(Long id);

    void editByID(Long id, Student student);

    void update(Long id, Student student);

    Student findById(Long id);

    List<Student> searchByName(String search);

}
