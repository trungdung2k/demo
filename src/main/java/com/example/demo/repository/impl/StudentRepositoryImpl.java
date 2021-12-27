package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomStudentRepository;
import com.example.demo.response.CustomClazz1Response;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

import java.util.List;



public class StudentRepositoryImpl  implements CustomStudentRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public long countStudentByClazz(Long id) {
        QStudent qStudent = QStudent.student;
        JPAQuery<Clazz> query = new JPAQuery<>(this.entityManager);
        return query.from(qStudent)
                .where(qStudent.clazz.id.eq(id)).fetchCount();
    }

    @Override
    public List<CustomClazz1Response> listStudentByClazz(List<Long> ids) {
        QStudent qStudent = QStudent.student;
        QClazz qClazz = QClazz.clazz;
        QTeacher qTeacher = QTeacher.teacher;
        QFaculty qFaculty = QFaculty.faculty;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return query.select(Projections.bean(CustomClazz1Response.class, qStudent.clazz.id.count().as("studentTotal"), qClazz.id.as("id"),
                        qClazz.clazzCode.as("clazzCode"),qClazz.clazzName.as("clazzName")))
                .from(qStudent)
                .innerJoin(qStudent.clazz, qClazz)
                .where(qStudent.clazz.id.in(ids))
                .groupBy(qClazz.id)
                .fetch();
    }
    @Override
    public List<String> findStudentNameByClazz(Long id) {
        QStudent qStudent = QStudent.student;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return query.from(qStudent)
                .select(qStudent.name)
                .where(qStudent.clazz.id.eq(id))
                .fetch();
    }

    @Override
    public List<Student> findAllStudent() {
        QStudent qStudent = QStudent.student;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return  query.from(qStudent).fetchAll().fetch();
    }
}
