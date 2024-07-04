package com.example.demo.models.services;

import com.example.demo.models.Classroom;
import com.example.demo.models.services.impl.ClassroomService;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
