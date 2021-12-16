package com.example.demo.model;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "clazzs")
public class Clazz   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clazzCode;
    private String clazzName;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Teacher teacher;
}
