package com.example.demo.repository;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface CustomTeacherRepository {
    List<Teacher> findAllTeacher();

}
