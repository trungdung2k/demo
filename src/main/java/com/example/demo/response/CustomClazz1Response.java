package com.example.demo.response;
import lombok.Data;


@Data
public class CustomClazz1Response {
        private Long id;
        private String clazzCode;
        private String clazzName;
        private Long studentTotal;
        private CustomFaculty1Response faculty;
        private CustomTeacher1Response teacher;


}