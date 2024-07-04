package com.example.demo.models.repositories.impl;

import com.example.demo.dto.StudentDTO;
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
    public List<StudentDTO> findAll() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select student.id, student.name, student.address, student.point," +
                            " c0324h1.classroom.name_class, classroom.id_class from student join c0324h1.classroom  on classroom.id_class" +
                            " = student.id_class");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            String address;
            Float point;
            String nameClass;
            Long idClass;
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                nameClass = resultSet.getString("name_class");
                idClass = Long.valueOf(resultSet.getString("id_class"));
                students.add(new StudentDTO(id, nameClass, idClass, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            String address;
            Float point;
            Long id_class;
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                id_class = resultSet.getLong("id_class");
                students.add(new Student(id, name, address, point, id_class));
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
                    prepareStatement("insert into student(name, address, point, id_class) value (?, ?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setLong(4, student.getId_class());
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

    public Student findById(Long id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from student where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            String address;
            Float point;
            Long idClass;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                idClass = Long.valueOf(resultSet.getString("id_class"));
                student = new Student(id, name, address, point, idClass);
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<StudentDTO> findByName(String search) {
        List<StudentDTO> result = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select student.id, student.name, student.address, student.point, classroom.name_class AS name_class from student join classroom  on classroom.id_class = student.id_class WHERE student.name LIKE CONCAT('%',?,'%')");
            statement.setString(1, search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nameS = resultSet.getString("name");
                String address = resultSet.getString("address");
                Float point = resultSet.getFloat("point");
                String nameClass = resultSet.getString("name_class");
                result.add(new StudentDTO(id,nameS,address,point,nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public void editById(Student student, Long id) {
        try {
            PreparedStatement PreparedStatement = BaseRepository.getConnection().
                    prepareStatement("update student set name = ?,address = ?, point =?, id_class =? where id = ?;");
            PreparedStatement.setString(1, student.getName());
            PreparedStatement.setString(2, student.getAddress());
            PreparedStatement.setFloat(3, student.getPoint());
            PreparedStatement.setLong(4, student.getId_class());
            PreparedStatement.setLong(5, id);
            PreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}