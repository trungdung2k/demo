package com.example.demo.entity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private String gender;

    private int age;

    @Column(length = 50)
    private String msv;

    @Column(length = 150)
    private String address;

    private int phone;

    @ManyToOne
    private Clazz clazz;

    @ManyToOne
    private Subject subject;
}


