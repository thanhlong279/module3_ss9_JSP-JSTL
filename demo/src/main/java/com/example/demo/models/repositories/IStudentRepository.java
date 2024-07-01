package com.example.demo.models.repositories;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteByID(Long id);

    void editById(Long id, Student student);
}
