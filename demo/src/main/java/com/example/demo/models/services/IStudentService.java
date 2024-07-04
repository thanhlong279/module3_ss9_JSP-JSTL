package com.example.demo.models.services;

import com.example.demo.dto.StudentDTO;
import com.example.demo.models.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteByID(Long id);

    void update(Student student, Long id);

    Student findById(Long id);

    List<StudentDTO> findByName(String search);



//    List<Student> searchByName(String search);

}
