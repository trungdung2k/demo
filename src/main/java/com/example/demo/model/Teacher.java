package com.example.demo.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
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