package com.example.demo.request;
import com.example.demo.entity.Teacher;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class TeacherRequest {
    private Long id;

    @NotBlank
    @Length(max = 255)
    private String nameTeacher;

    private int age;

    @NotBlank
    @Length(max = 255)
    private String gender;

    private Long clazzId;

    public Teacher asCreatedTeacher(){
        Teacher teacher = new Teacher();
        teacher.setNameTeacher(this.getNameTeacher());
        teacher.setAge(this.getAge());
        teacher.setGender(this.getGender());

        return teacher;
    }

    public Teacher asUpdatedTeacher(Teacher teacher){
        teacher.setNameTeacher(this.getNameTeacher());
        teacher.setAge(this.getAge());
        teacher.setGender(this.getGender());

        return teacher;
    }
}
