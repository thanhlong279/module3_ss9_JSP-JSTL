package com.example.demo.models.services.impl;

import com.example.demo.models.Student;
import com.example.demo.models.repositories.IStudentRepository;
import com.example.demo.models.repositories.impl.StudentRepository;
import com.example.demo.models.services.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements IStudentService {
  private static IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Boolean deleteByID(Long id) {
        return studentRepository.deleteByID(id);
    }

    @Override
    public void editByID(Long id, Student student) {
         studentRepository.editById(id, student);
    }

    public Student findById(Long id) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }



    @Override
    public List<Student> searchByName(String search) {
        List<Student> students = findAll();
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(search)) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public void update(Long id, Student student) {
        studentRepository.editById(id, student);
    }



}
