package com.example.demo.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "facultys")

public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facultyName;
    private String facultyCode;

}
