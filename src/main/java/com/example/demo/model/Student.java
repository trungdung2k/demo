package com.example.demo.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String msv;
    private String address;
    private int phone;

    @ManyToOne
    private Clazz clazz;

    @ManyToOne
    private Teacher teacher;
}


