package com.example.demo.model;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Data
@Entity
@QueryEntity
@Table(name = "clazzs")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clazzCode;
    private String clazzName;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Teacher teacher;
}
