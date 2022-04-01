package com.example.demo.entity;

import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nameTeacher;

    private int age;

    private String gender;

    @OneToOne
    private Clazz clazz;
}