package com.example.backend.repository;

import java.util.List;

import com.example.backend.model.Students;

public interface IStudentsRepository {
    public Students insertStudents(Students students);

    public List<Students> getAllStudents();

    public Students updateStudents(int id, Students students);

    public Students deleteStudents(int id);

    public Students getStudents(int id);
}