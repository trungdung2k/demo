package com.example.demo.repository;
import com.example.demo.model.Clazz;
import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import com.example.demo.response.CustomClazzResponse;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository

public interface ClazzRepository extends JpaRepository<Clazz , Long> , CustomClazzRepository {

}
