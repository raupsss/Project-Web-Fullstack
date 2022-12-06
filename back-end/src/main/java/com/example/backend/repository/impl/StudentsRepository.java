package com.example.backend.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Students;
import com.example.backend.repository.IStudentsRepository;

@Repository
public class StudentsRepository implements IStudentsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Students insertStudents(Students students) {

        String query = "INSERT INTO tb_students(deskripsi_diri, email, hard_skill, interest, jenis_kelamin, nama, soft_skill, umur) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[] {
                students.getDeskripsi_diri(), students.getEmail(), students.getHard_skill(), students.getInterest(),
                students.getJenis_kelamin(), students.getNama(), students.getSoft_skill(), students.getUmur()
        });
        return students;
    }

    @Override
    public List<Students> getAllStudents() {

        String query = "SELECT * FROM tb_students";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Students.class));

    }

    @Override
    public Students updateStudents(int id, Students students) {

        String query = "UPDATE tb_students SET deskripsi_diri = ?, email = ?, hard_skill = ?, interest = ?, jenis_kelamin = ?, nama = ?, soft_skill = ?, umur = ? WHERE id = ?";

        jdbcTemplate.update(query, new Object[] {
                students.getDeskripsi_diri(), students.getEmail(), students.getHard_skill(),
                students.getInterest(), students.getJenis_kelamin(), students.getNama(), students.getSoft_skill(),
                students.getUmur(), id
        });
        return students;
    }

    @Override
    public Students deleteStudents(int id) {

        String query = "SELECT * FROM tb_students WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Students.class), id);

        query = "DELETE FROM tb_students WHERE id = ?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public Students getStudents(int id) {

        String query = "SELECT * FROM tb_students WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Students.class), id);

    }

}
