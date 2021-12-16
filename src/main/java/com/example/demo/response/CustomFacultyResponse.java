package com.example.demo.response;
import lombok.Data;

@Data
public class CustomFacultyResponse {
    private Long id;
    private String facultyName;
    private String facultyCode;
    private Long clazzTotal;
}
