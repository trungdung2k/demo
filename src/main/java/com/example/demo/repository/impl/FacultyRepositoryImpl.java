package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomFacultyRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;

public class FacultyRepositoryImpl implements CustomFacultyRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Faculty> findAllFaculty() {
        QFaculty qFaculty = QFaculty.faculty;
        JPAQuery<Faculty> query = new JPAQuery<>(this.entityManager);
        return  query.from(qFaculty).fetchAll().fetch();
    }
}
