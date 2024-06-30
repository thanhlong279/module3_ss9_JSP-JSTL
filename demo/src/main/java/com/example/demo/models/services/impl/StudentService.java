package com.example.demo.models.services.impl;

import com.example.demo.models.Student;
import com.example.demo.models.repositories.IStudentRepository;
import com.example.demo.models.repositories.impl.StudentRepository;
import com.example.demo.models.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
  private static IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
