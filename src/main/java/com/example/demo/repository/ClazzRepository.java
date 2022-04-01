package com.example.demo.repository;
import com.example.demo.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClazzRepository extends JpaRepository<Clazz , Long> , CustomClazzRepository {

    Optional<Clazz> findByIdAndDeleteFalse(Long id);

    boolean existsByClazzNameAndIdNot(String clazzName, Long id);

    boolean existsByClazzCodeAndIdNot(String clazzCode, Long id);

    Clazz getById(Long id);
}
