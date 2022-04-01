package com.example.demo.response;
import com.example.demo.entity.Clazz;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class CustomClazzResponse  {
        private Long id;
        private String clazzCode;
        private String clazzName;
        private Long studentTotal;
        private Faculty faculty;
        private Teacher teacher;
        private List<String> studentName;

        public CustomClazzResponse(Clazz clazz , Long studentTotal , List<String> studentName) {
                this.id = clazz.getId();
                this.clazzCode = clazz.getClazzCode();
                this.clazzName = clazz.getClazzName();
                this.teacher = clazz.getTeacher();
                this.faculty = clazz.getFaculty();
                this.studentTotal  = studentTotal;
                this.studentName = studentName;
        }

}