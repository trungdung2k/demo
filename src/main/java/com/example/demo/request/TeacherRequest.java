package com.example.demo.request;
import lombok.Data;
@Data
public class TeacherRequest {
    private Long id;
    private String nameTeacher;
    private int age;
    private String gender;
    private Long clazzId;
}
