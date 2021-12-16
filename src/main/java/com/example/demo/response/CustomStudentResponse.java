package com.example.demo.response;
import lombok.Data;

@Data
public class CustomStudentResponse {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String msv;
    private String address;
    private int phone;
    private String clazzCode;
}
