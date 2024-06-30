package com.example.demo.models.repositories.impl;
import com.example.demo.models.Student;
import com.example.demo.models.repositories.IStudentRepository;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L,"haiTT", "QN", 10.0f));
        students.add(new Student(2L,"Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L,"Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L,"Cook", "Bàn ăn", 2f));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
