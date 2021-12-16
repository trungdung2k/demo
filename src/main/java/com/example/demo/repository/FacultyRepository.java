package com.example.demo.repository;

import com.example.demo.model.Faculty;
import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository< Faculty, Long>, CustomFacultyRepository{

    Faculty getById(Long id);

}
