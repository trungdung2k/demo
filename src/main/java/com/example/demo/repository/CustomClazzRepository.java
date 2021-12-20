package com.example.demo.repository;
import com.example.demo.model.Clazz;
import com.example.demo.model.Faculty;
import com.example.demo.model.Teacher;
import com.example.demo.response.CustomClazzResponse;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CustomClazzRepository  {

    long countClazzByFaculty(Long id);

    List<Clazz> findClazzByTeacher(Long id);

    List<Clazz> findAllClazz();

}
