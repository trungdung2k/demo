package com.example.demo.repository;

import com.example.demo.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long>, CustomMarksRepository {
    Marks getById(Long id);
}
