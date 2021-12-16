package com.example.demo.request;
import lombok.Data;

@Data
public class ClazzRequest {
        private  Long id;
        private String clazzCode;
        private String clazzName;
        private String facultyName;
        private Long teacherId;
        private Long facultyId;

}

