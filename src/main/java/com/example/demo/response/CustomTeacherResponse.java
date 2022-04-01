package com.example.demo.response;
import lombok.Data;

import java.util.List;

@Data
public class CustomTeacherResponse {
    private Long id;
    private String nameTeacher;
    private int age;
    private String gender;
    private List<CustomClazzResponse> clazzList;
}
