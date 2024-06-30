package com.example.demo.models.repositories;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
