package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Students;

public interface IStudentsService {
    public Students insertStudents(Students students);

    public List<Students> getAllStudents();

    public Students updateStudents(int id, Students students);

    public Students deleteStudents(int id);

    public Students getStudents(int id);
}