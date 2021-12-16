package com.example.demo.request;
import lombok.Data;
@Data
public class StudentRequest {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String msv;
    private String address;
    private int phone;
    private Long clazzId;
    private Long teacherId;
    private Long facultyId;
}
