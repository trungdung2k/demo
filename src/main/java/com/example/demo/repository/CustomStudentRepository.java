package com.example.demo.repository;
import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomClazzResponse;
import com.example.demo.response.CustomStudent1Response;

import java.util.List;

public interface CustomStudentRepository {

   long countStudentByClazz(Long id);


    List<String> findStudentNameByClazz(Long id);


    List<Student> findAllStudent();


    List<CustomStudent1Response> findListStudent(List<Long> ids);
}
