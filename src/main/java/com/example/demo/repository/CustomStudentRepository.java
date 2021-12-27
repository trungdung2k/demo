package com.example.demo.repository;
import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomClazzResponse;

import java.util.List;

public interface CustomStudentRepository {

   long countStudentByClazz(Long id);

    List<CustomClazz1Response> listStudentByClazz(List<Long> ids);

    List<String> findStudentNameByClazz(Long id);

    List<Student> findAllStudent();
}
