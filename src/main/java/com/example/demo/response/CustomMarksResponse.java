package com.example.demo.response;

import lombok.Data;

@Data
public class CustomMarksResponse {
    private Long id;
    private String nameSubject;
    private String codeSubject;
    private Double marks;
    private String marksLetter;
}
