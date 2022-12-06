package com.example.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Students;
import com.example.backend.repository.IStudentsRepository;
import com.example.backend.service.IStudentsService;

@Service
public class StudentsService implements IStudentsService {

    @Autowired
    IStudentsRepository studentsRepository;

    @Override
    public Students insertStudents(Students students) {

        return studentsRepository.insertStudents(students);
    }

    @Override
    public List<Students> getAllStudents() {

        return studentsRepository.getAllStudents();
    }

    @Override
    public Students updateStudents(int id, Students students) {

        return studentsRepository.updateStudents(id, students);
    }

    @Override
    public Students deleteStudents(int id) {

        return studentsRepository.deleteStudents(id);
    }

    @Override
    public Students getStudents(int id) {
        
        return studentsRepository.getStudents(id);
    }

}