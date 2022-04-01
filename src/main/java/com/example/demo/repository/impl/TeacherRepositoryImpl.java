package com.example.demo.repository.impl;
import com.example.demo.entity.*;
import com.example.demo.repository.CustomTeacherRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;

public class TeacherRepositoryImpl implements CustomTeacherRepository {


    @Autowired
    EntityManager entityManager;



    @Override
    public List<Teacher> findAllTeacher() {
        QTeacher qTeacher = QTeacher.teacher;
        JPAQuery<Teacher> query = new JPAQuery<>(this.entityManager);
        return  query.from(qTeacher).fetchAll().fetch();
    }
}
