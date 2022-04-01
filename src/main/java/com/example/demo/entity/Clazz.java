package com.example.demo.entity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "clazzs")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String clazzCode;

    @Column(length = 50)
    private String clazzName;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Teacher teacher;

}
