package com.example.demo.response;
import com.example.demo.model.Clazz;
import com.example.demo.model.Faculty;
import com.example.demo.model.Teacher;
import lombok.Data;

@Data
public class CustomClazzResponse  {
        private Long id;
        private String clazzCode;
        private String clazzName;
        private Long studentTotal;
        private Faculty faculty;
        private Teacher teacher;

        public CustomClazzResponse(Clazz clazz) {
                this.id = clazz.getId();
                this.clazzCode = clazz.getClazzCode();
                this.clazzName = clazz.getClazzName();
                this.teacher = clazz.getTeacher();
                this.faculty = clazz.getFaculty();
//               this.studentTotal  = ;
        }

        public CustomClazzResponse() {
        }
}
