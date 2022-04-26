package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(MarksKey.class)
@Table(name = "marks")
public class Marks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String msv;

    private String nameSubject;

    @Id
    private String codeSubject;

    private Double marks;

    private String marksLetter;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;
}
