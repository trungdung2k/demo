package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomStudentRepository;
import com.example.demo.response.CustomClazz1Response;
import com.example.demo.response.CustomFaculty1Response;
import com.example.demo.response.CustomStudent1Response;
import com.example.demo.response.CustomTeacher1Response;
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


    @Override
    public List<CustomStudent1Response> findListStudent(List<Long> ids) {
        QStudent qStudent = QStudent.student;
        QClazz qClazz = QClazz.clazz;
        QTeacher qTeacher = QTeacher.teacher;
        QFaculty qFaculty = QFaculty.faculty;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return  query.select(
                Projections.bean(CustomStudent1Response.class , qStudent.id.as("id"), qStudent.name.as("name"), qStudent.age.as("age"), qStudent.address.as("address"), qStudent.phone.as("phone"),
                    qStudent.msv.as("msv"), qStudent.gender.as("gender"),
                Projections.bean(CustomClazz1Response.class,qStudent.clazz.clazzCode.as("clazzCode"), qStudent.clazz.clazzName.as("clazzName"),qStudent.clazz.id.as("id"), qStudent.clazz.id.count().as("studentTotal"),

                Projections.bean(CustomFaculty1Response.class, qClazz.faculty.facultyName.as("facultyName"),qClazz.faculty.id.as("id"),
                                qClazz.faculty.facultyCode.as("facultyCode")).as("faculty"),
                Projections.bean(CustomTeacher1Response.class, qClazz.teacher.id.as("id"),qClazz.teacher.nameTeacher.as("nameTeacher"),
                                qClazz.teacher.age.as("age"),qClazz.teacher.gender.as("gender")).as("teacher")).as("clazz")))
                .from(qStudent)
                .innerJoin(qStudent.clazz, qClazz)
                .innerJoin(qClazz.faculty ,qFaculty)
                .innerJoin(qClazz.teacher,qTeacher)
                .where(qClazz.id.in(ids) , qClazz.faculty.id.eq(qFaculty.id),qClazz.teacher.id.eq(qTeacher.id))
                .groupBy(qStudent.id , qClazz.id, qFaculty.id , qTeacher.id)
                .fetch();
    }
}
