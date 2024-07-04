package com.example.demo.models.services.impl;

import com.example.demo.models.Classroom;
import com.example.demo.models.repositories.IClassroomRepository;
import com.example.demo.models.repositories.impl.ClassroomRepository;
import com.example.demo.models.services.IClassroomService;

import java.util.List;

public class ClassroomService implements IClassroomService {
    private IClassroomRepository classroomRepository = new ClassroomRepository();
    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
