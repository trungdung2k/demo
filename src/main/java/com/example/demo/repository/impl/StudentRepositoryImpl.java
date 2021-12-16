package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomStudentRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


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

//    @Override
//    public Map<Long, Long> countStudentByClazz(List<Long> classIds) {
//        QStudent qStudent = QStudent.student;
//        JPAQuery<Clazz> query = new JPAQuery<>(this.entityManager);
//        List<Clazz> clazzList = query.from(qStudent)
//                .where(qStudent.clazz.id.in(classIds)).fetch();
//    }

    @Override
    public List<Student> findAllStudent() {
        QStudent qStudent = QStudent.student;
        JPAQuery<Student> query = new JPAQuery<>(this.entityManager);
        return  query.from(qStudent).fetchAll().fetch();
    }
}
