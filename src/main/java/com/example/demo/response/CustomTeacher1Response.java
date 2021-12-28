package com.example.demo.response;
import com.example.demo.model.Teacher;
import lombok.Data;
@Data
public class CustomTeacher1Response {
    private Long id;
    private String nameTeacher;
    private int age;
    private String gender;

//    public CustomTeacher1Response(Teacher teacher){
//        this.id = teacher.getId();
//        this.nameTeacher = teacher.getNameTeacher();
//        this.age = teacher.getAge();
//        this.gender = teacher.getGender();
//    }
}
