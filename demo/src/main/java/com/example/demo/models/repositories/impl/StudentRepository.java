package com.example.demo.models.repositories.impl;

import com.example.demo.models.Student;
import com.example.demo.models.repositories.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L, "haiTT", "QN", 10.0f));
        students.add(new Student(2L, "Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L, "Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L, "Cook", "Bàn ăn", 2f));
    }


    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from student order by name");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            String address;
            Float point;
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                students.add(new Student(id, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("insert into student(name, address, point) value (?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteByID(Long id) {
        boolean isDelete;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("delete from student where id = ?");
            preparedStatement.setLong(1, id);
            isDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

//    @Override
//    public void editById(Long id, Student student) {
//        for (Student student1 : students) {
//            if (student1.getId().equals(id)) {
//                student1.setName(student.getName());
//                student1.setAddress(student.getAddress());
//                student1.setPoint(student.getPoint());
//            }
//        }
//    }

    public void editById(Long id, Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("update student set name = ?,address = ?, point =? where id = ?;");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setLong(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}