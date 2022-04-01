package com.example.demo.repository;
import com.example.demo.entity.Clazz;
import com.example.demo.response.CustomClazz1Response;


import java.util.List;

public interface CustomClazzRepository  {

    long countClazzByFaculty(Long id);

    List<Clazz> findClazzByTeacher(Long id);

    List<Clazz> findAllClazz();

    List<CustomClazz1Response> listClazz(List<Long> ids);
}
