package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomClazzRepository;
import com.example.demo.response.*;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;

public class ClazzRepositoryImpl  implements CustomClazzRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public long countClazzByFaculty(Long id) {
        QClazz qClazz = QClazz.clazz;
        JPAQuery<Faculty> query = new JPAQuery<>(this.entityManager);
        return query.from(qClazz)
                .where(qClazz.faculty.id.eq(id)).fetchCount();
    }
    @Override
    public List<Clazz> findClazzByTeacher(Long id) {
         QClazz qClazz = QClazz.clazz;
        JPAQuery<Clazz> query = new JPAQuery<>(this.entityManager);
        return  query.from(qClazz)
                .where(qClazz.teacher.id.eq(id)).fetchAll().fetch();
    }

    @Override
        public List<Clazz> findAllClazz() {
            QClazz qClazz = QClazz.clazz;
        JPAQuery<Clazz> query = new JPAQuery<>(this.entityManager);
        return  query.from(qClazz).fetchAll().fetch();
    }

    @Override
    public List<CustomClazz1Response> listClazz(List<Long> ids) {
        QStudent qStudent = QStudent.student;
        QClazz qClazz = QClazz.clazz;
        QTeacher qTeacher = QTeacher.teacher;
        QFaculty qFaculty = QFaculty.faculty;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return query.select(Projections.bean(CustomClazz1Response.class, qStudent.clazz.id.count().as("studentTotal"), qClazz.id.as("id")
                ,qClazz.clazzCode.as("clazzCode"), qClazz.clazzName.as("clazzName"),
                        Projections.bean(CustomFaculty1Response.class, qClazz.faculty.facultyName.as("facultyName"),qClazz.faculty.id.as("id"),
                                qClazz.faculty.facultyCode.as("facultyCode")).as("faculty"),
                        Projections.bean(CustomTeacher1Response.class, qClazz.teacher.id.as("id"),qClazz.teacher.nameTeacher.as("nameTeacher"),
                                qClazz.teacher.age.as("age"),qClazz.teacher.gender.as("gender")).as("teacher")))
                .from(qStudent)
                .innerJoin(qStudent.clazz, qClazz )
                .innerJoin(qClazz.teacher, qTeacher)
                .innerJoin(qClazz.faculty,qFaculty)
                .where(qStudent.clazz.id.in(ids),qClazz.teacher.id.eq(qTeacher.id),qClazz.faculty.id.eq(qFaculty.id))
                .groupBy(qClazz.id, qFaculty.id,qTeacher.id)
                .fetch();
    }
}
