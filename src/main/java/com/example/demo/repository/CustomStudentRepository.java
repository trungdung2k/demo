package com.example.demo.repository;
import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

import java.util.List;
import java.util.Map;

public interface CustomStudentRepository {

    long countStudentByClazz(Long id);


    List<String> findStudentNameByClazz(Long id);

//    long countStudentByTeacher(Long studentTotal);

    List<Student> findAllStudent();
}
