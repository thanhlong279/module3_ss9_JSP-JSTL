package com.example.demo.models.services.impl;

import com.example.demo.dto.StudentDTO;
import com.example.demo.models.Student;
import com.example.demo.models.repositories.IStudentRepository;
import com.example.demo.models.repositories.impl.StudentRepository;
import com.example.demo.models.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
  private static IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<StudentDTO> findAll() {
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






    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<StudentDTO> findByName(String search) {
        return studentRepository.findByName(search);
    }


//    @Override
//    public List<Student> searchByName(String search) {
//        List<Student> students = findAll();
//        List<Student> result = new ArrayList<>();
//        for (Student student : students) {
//            if (student.getName().contains(search)) {
//                result.add(student);
//            }
//        }
//        return result;
//    }

    @Override
    public void update(Student student, Long id) {
        studentRepository.editById(student, id);
    }



}
