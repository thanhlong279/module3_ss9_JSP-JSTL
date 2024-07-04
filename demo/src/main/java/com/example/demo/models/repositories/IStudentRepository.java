package com.example.demo.models.repositories;

import com.example.demo.dto.StudentDTO;
import com.example.demo.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDTO> findAll();

    List<Student> getAll();

    void save(Student student);

    Boolean deleteByID(Long id);

    void editById(Student student, Long id);

    Student findById(Long id);

    List<StudentDTO> findByName(String search);

}
