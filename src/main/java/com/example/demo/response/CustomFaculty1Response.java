package com.example.demo.response;

import com.example.demo.model.Faculty;
import com.querydsl.core.types.dsl.SimpleExpression;
import lombok.Data;

@Data
public class CustomFaculty1Response {
    private Long id;
    private String facultyName;
    private String facultyCode;


//    public CustomFaculty1Response(Faculty faculty) {
//        this.id = faculty.getId();
//        this.facultyName = faculty.getFacultyName();
//        this.facultyCode = faculty.getFacultyCode();
//    }
}

