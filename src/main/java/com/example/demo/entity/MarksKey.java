package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarksKey implements Serializable {
    private String msv;

    private String codeSubject;
}
