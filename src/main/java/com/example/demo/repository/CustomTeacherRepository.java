package com.example.demo.repository;

import com.example.demo.model.Clazz;
import com.example.demo.model.Teacher;

import java.util.List;

public interface CustomTeacherRepository {
    List<Teacher> findAllTeacher();

}
