package com.example.demo.response;
import lombok.Data;

@Data
public class CustomStudent1Response {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String msv;
    private String address;
    private int phone;
    private CustomClazz1Response clazz;

}