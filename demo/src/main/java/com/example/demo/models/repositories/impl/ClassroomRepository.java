package com.example.demo.models.repositories.impl;

import com.example.demo.models.Classroom;
import com.example.demo.models.repositories.IClassroomRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomRepository implements IClassroomRepository {
    @Override
    public List<Classroom> findAll() {
        List<Classroom> classrooms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from classroom");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            while (resultSet.next()){
                id = resultSet.getLong("id_class");
                name = resultSet.getString("name_class");
                classrooms.add(new Classroom(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classrooms;
    }


}
