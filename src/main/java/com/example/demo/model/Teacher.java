package com.example.demo.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;

@Data
@Entity
@QueryEntity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameTeacher;
    private int age;
    private String gender;
    @OneToOne
    private Clazz clazz;
}