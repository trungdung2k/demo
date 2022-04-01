package com.example.demo.entity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "facultys")

public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String facultyName;

    @Column(length = 50)
    private String facultyCode;

}
