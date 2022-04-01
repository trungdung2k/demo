package com.example.demo.repository;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>, CustomStudentRepository {
    Student getById(long id);

    Optional<Student> findByIdAndDeleteFalse(Long id);

    boolean exitsByMsvAndIdNot(String msv, Long id);
}
