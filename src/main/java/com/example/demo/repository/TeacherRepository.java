package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher , Long>, CustomTeacherRepository {

    Teacher getById(Long id);

    Optional<Teacher> findByIdAndDeleteFalse(Long id);
}
