package com.example.demo.models.repositories;

import com.example.demo.models.Classroom;

import java.util.List;

public interface IClassroomRepository {
    List<Classroom> findAll();
}
