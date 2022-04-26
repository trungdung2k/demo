package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nameSubject;

    @Id
    public String codeSubject;

}
