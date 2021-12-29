package com.example.demo.response;
import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import lombok.Data;

import java.util.List;


@Data
public class CustomClazz1Response {
        private Long id;
        private String clazzCode;
        private String clazzName;
        private Long studentTotal;
        private CustomFaculty1Response faculty;
        private CustomTeacher1Response teacher;


}