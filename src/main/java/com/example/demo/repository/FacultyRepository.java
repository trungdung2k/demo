package com.example.demo.repository;

import com.example.demo.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository< Faculty, Long>, CustomFacultyRepository{

    Faculty getById(Long id);

}
