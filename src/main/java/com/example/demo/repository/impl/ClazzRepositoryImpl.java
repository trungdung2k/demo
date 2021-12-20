package com.example.demo.repository.impl;
import com.example.demo.model.*;
import com.example.demo.repository.CustomClazzRepository;
import com.example.demo.response.CustomClazzResponse;
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
}
